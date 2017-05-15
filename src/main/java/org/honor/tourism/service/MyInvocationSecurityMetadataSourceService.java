package org.honor.tourism.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.honor.tourism.entity.Module;
import org.honor.tourism.entity.SysRole;
import org.honor.tourism.entity.SysUser;
import org.honor.tourism.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

@Service
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

	@Autowired
	private ModuleRepository moduleRepository;

	private HashMap<String, Collection<ConfigAttribute>> map = null;

	/**
	 * 加载资源，初始化资源变量
	 */
	public void loadResourceDefine() {
		map = new HashMap<>();
		Collection<ConfigAttribute> array;
		ConfigAttribute cfg;
		List<Module> permissions = moduleRepository.findAll();
		for (Module module : permissions) {
			array = new ArrayList<>();
			
			List<SysRole> sysRole = module.getSysRoleList();
			for (SysRole sysRole2 : sysRole) {
				cfg = new SecurityConfig(sysRole2.getName());
				array.add(cfg);
			}
			map.put(module.getLinkddress(), array);
		}

	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		if (map == null)
			loadResourceDefine();
		HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
		AntPathRequestMatcher matcher;
		String resUrl;
		for (Iterator<String> iter = map.keySet().iterator(); iter.hasNext();) {
			resUrl = iter.next();
			matcher = new AntPathRequestMatcher(resUrl);
			if (matcher.matches(request)) {
				return map.get(resUrl);
			}
		}
		return null;
	}

	/**
	 * 判断是否有权限
	 * @param collection
	 * @param request
	 * @return
	 */
	public boolean isHaveRole(FilterInvocation filterInvocation) {
		Collection<ConfigAttribute> collection = getAttributes(filterInvocation);
		HttpServletRequest request = filterInvocation.getHttpRequest();
		if (collection == null) return true;
		
		HttpSession session = request.getSession();
		SecurityContext securityContext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		SysUser user = (SysUser) securityContext.getAuthentication().getPrincipal();
		List<SysRole> roles = user.getRoles();
		
		for (Iterator<ConfigAttribute> iterator = collection.iterator(); iterator.hasNext();) {
			ConfigAttribute cfg = (ConfigAttribute) iterator.next();
			String roleName = cfg.getAttribute();
			
			for (SysRole sysRole : roles) {
				if (roleName.equals(sysRole.getName())) {
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
}