package org.honor.tourism.repository;

import java.util.List;

import org.honor.tourism.entity.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 作者:修罗大人
 * 日期:Feb 17, 2017
 * 时间:10:06:55 AM
 */

public interface ModuleRepository extends JpaRepository<Module, String> {

	/**
	 * 根据父级查询
	 * @return
	 */
	public List<Module> findByParentModuleId(String id);
	
	/**
	 * 根据条件查询模块
	 * @param moduleName
	 * @param parentModuleId
	 * @return
	 */
	public Page<Module> findModules(String moduleName,String parentModuleId, Pageable pageable);
	
}
