package org.honor.tourism.service;

import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * 作者:修罗大人
 * 日期:Feb 8, 2017
 * 时间:9:29:12 AM
 * SysUserService
 */
public interface SysUserService extends CrudService<SysUser> {

	public SysUser save(SysUser sysUser);
	
	public SysUser findByLogin();
	
	/**
	 * 批量删除员工
	 * @param userIds
	 * @return
	 */
	public void deleteUsers(List<String> userIds);
	
	/**
	 * 根据条件查询员工
	 * @param name
	 * @param username
	 * @param deptId
	 */
	public Page<SysUser> findUsersByNameAndUsernameAndDeptId(String name,String username,String deptId,Pageable pageable);
	
	/**
	 * 初始化员工密码
	 * @param userId
	 * @param passwrod
	 * @return
	 */
	public SysUser resetPassword(String userId,String passwrod);
	
}
