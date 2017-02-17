package org.honor.tourism.service;

import java.util.List;

import org.honor.tourism.entity.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 作者:修罗大人
 * 日期:Feb 14, 2017
 * 时间:4:47:38 PM
 * 角色service
 */

public interface SysRoleService extends CrudService<SysRole> {

	/**
	 * 批量删除角色
	 * @param ids
	 */
	public void deleteRoles(List<String> ids); 
	
	/**
	 * 查询角色
	 * @param roleName
	 * @return
	 */
	public Page<SysRole> findRoles(String roleName,Pageable pageable); 
	
	/**
	 * 查询全部角色返回tree
	 * @return
	 */
	public List<SysRole> findTree();
	
	/**
	 * 设置用户角色
	 * @param userId
	 * @param roleCodes
	 * @param roles
	 */
	public void setUserRoles(String userId,String[] roleIds);
	
	/**
	 * 设置角色用户
	 * @param userId
	 * @param roleCodes
	 * @param roles
	 */
	public void setRoleUsers(String[] userIds,String roleId);
	
}
