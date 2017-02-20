package org.honor.tourism.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.Module;
import org.honor.tourism.entity.SysRole;
import org.honor.tourism.entity.SysUser;
import org.honor.tourism.repository.ModuleRepository;
import org.honor.tourism.repository.SysRoleRepository;
import org.honor.tourism.repository.SysUserRepository;
import org.honor.tourism.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 作者:修罗大人
 * 日期:Feb 14, 2017
 * 时间:4:48:47 PM
 * 角色serviceImpl
 */
@Service
public class SysRoleServiceImpl extends CrudServiceImpl<SysRole> implements SysRoleService {

	@Autowired
	private SysRoleRepository repository;
	
	@Autowired
	private SysUserRepository userRepository;
	
	@Autowired
	private ModuleRepository moduleRepository;
	
	@Autowired
	public SysRoleServiceImpl(JpaRepository<SysRole, String> repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 批量删除角色
	 * @param ids
	 */
	public void deleteRoles(List<String> ids)
	{
		for (String id : ids) {
			repository.delete(id);
		}
	}
	
	/**
	 * 查询角色
	 * @param roleName
	 * @return
	 */
	public Page<SysRole> findRoles(String roleName,Pageable pageable)
	{
		Page<SysRole> roles = repository.findRoles(roleName,pageable);
		return roles;
	}
	
	/**
	 * 查询全部角色返回tree
	 * @return
	 */
	public List<SysRole> findTree()
	{
		return repository.findAll();
	}
	
	/**
	 * 设置用户角色
	 * @param userId
	 * @param roleCodes
	 * @param roles
	 */
	public void setUserRoles(String userId,String[] roleIds)
	{
		List<SysRole> roles = new ArrayList<SysRole>();
		for (int i = 0; i < roleIds.length; i++) 
		{
			SysRole roleTemp = repository.findOne(roleIds[i]);
			roles.add(roleTemp);
		}
		
		SysUser user = userRepository.findOne(userId);
		user.setRoles(roles);
		
		userRepository.save(user);
	}
	
	/**
	 * 设置角色用户
	 * @param userId
	 * @param roleCodes
	 * @param roles
	 */
	public void setRoleUsers(String[] userIds,String roleId)
	{
		SysRole role = repository.findOne(roleId);
		
		List<SysUser> users = role.getUsers();
		for (int i = 0; i < users.size(); i++) 
		{
			SysUser user = users.get(i);
			user.getRoles().remove(role);
			userRepository.save(user);
		}

		for (int i = 0; i < userIds.length; i++) 
		{
			SysUser user = userRepository.findOne(userIds[i]);
			if (user == null) return;
			List<SysRole> roles = user.getRoles();
			roles.add(role);
			userRepository.save(user);
		}
	}
	
	/** 设置模块角色
	 * @param userId
	 * @param roleCodes
	 * @param roles
	 */
	public void setModuleRoles(String moduleId,String[] roleIds)
	{
		Module module = moduleRepository.findOne(moduleId);
		
		List<SysRole> roles = module.getSysRoleList();
		for (int i = 0; i < roles.size(); i++) 
		{
			SysRole role = roles.get(i);
			role.getModuleList().remove(module);
			repository.save(role);
		}

		for (int i = 0; i < roleIds.length; i++) 
		{
			SysRole role = repository.findOne(roleIds[i]);
			if (role == null) return;
			List<Module> modules = role.getModuleList();
			modules.add(module);
			repository.save(role);
		}
	}

	/** 设置角色模块
	 * @param roleId
	 * @param roleCodes
	 * @return
	 */
	public void setRoleModules(String roleId,String[] moduleIds)
	{
		SysRole role = repository.findOne(roleId);
		
		List<Module> modules = new ArrayList<Module>();
		for (int i = 0; i < moduleIds.length; i++) 
		{
			Module module = moduleRepository.findOne(moduleIds[i]);
		    if (module != null) modules.add(module);
		}
		role.setModuleList(modules);
		repository.save(role);
	}

	/**
	 * findOne
	 * @param id
	 * @return
	 */
	public SysRole findOne(String id) {
		SysRole role = repository.findOne(id);
		return role;
	}
}
