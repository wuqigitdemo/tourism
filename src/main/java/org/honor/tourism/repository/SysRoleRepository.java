package org.honor.tourism.repository;
import java.util.List;

import org.honor.tourism.entity.Module;
import org.honor.tourism.entity.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 作者:修罗大人
 * 日期:Feb 14, 2017
 * 时间:4:50:42 PM
 * 角色Repository
 */

public interface SysRoleRepository extends JpaRepository<SysRole,String> {

	/**
	 * 查询角色
	 * @param roleName
	 * @return
	 */
	public Page<SysRole> findRoles(String roleName,Pageable pageable);
	
}
