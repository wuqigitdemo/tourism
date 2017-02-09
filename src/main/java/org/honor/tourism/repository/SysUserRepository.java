package org.honor.tourism.repository;

import java.util.List;

import org.honor.tourism.entity.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 作者:修罗大人
 * 日期:Feb 8, 2017
 * 时间:9:29:12 AM
 * SysUserRepository
 */
public interface SysUserRepository extends JpaRepository<SysUser, String> {

	SysUser findByUsername(String username);

	/**
	 * 根据条件查询员工
	 * @param name
	 * @param username
	 * @param deptId
	 */
	public Page<SysUser> findUsersByNameAndUsernameAndDeptId(String name,String username,String deptId,Pageable pageable);
}
