package org.honor.tourism.service.impl;

import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.SysUser;
import org.honor.tourism.repository.SysUserRepository;
import org.honor.tourism.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * 作者:修罗大人
 * 日期:Feb 8, 2017
 * 时间:9:29:12 AM
 * SysUserServiceImpl
 */
@Service
public class SysUserServiceImpl extends CrudServiceImpl<SysUser> implements SysUserService {
	
	@Autowired
	public SysUserServiceImpl(JpaRepository<SysUser, String> repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private SysUserRepository repository;

	@Override
	public SysUser save(SysUser sysUser) {
		return repository.save(sysUser);
	}

	@Override
	public SysUser findByLogin() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		String username = userDetails.getUsername();
		return repository.findByUsername(username);
	}
	
	/**
	 * 批量删除员工
	 * @param userIds
	 * @return
	 */
	public void deleteUsers(List<String> userIds)
	{
		for (String id : userIds) {
			repository.delete(id);
		}
	}
	
	/**
	 * 根据条件查询员工
	 * @param name
	 * @param username
	 * @param deptId
	 */
	public Page<SysUser> findUsersByNameAndUsernameAndDeptId(String name,String username,String deptId,Pageable pageable)
	{
		return repository.findUsersByNameAndUsernameAndDeptId(name, username, deptId,pageable);
	}

	/**
	 * 初始化员工密码
	 * @param userId
	 * @param passwrod
	 * @return
	 */
	@Override
	public SysUser resetPassword(String userId, String passwrod)
	{
		SysUser user = repository.findOne(userId);
		
		if (user != null) {
			user.setPassword(passwrod);
			return repository.save(user);
		}
		
		return null;
	}
}
