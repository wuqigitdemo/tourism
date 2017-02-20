package org.honor.tourism.service;

import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.Department;
import org.honor.tourism.entity.Module;
import org.honor.tourism.util.EasyuiPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 作者:修罗大人
 * 日期:Feb 17, 2017
 * 时间:10:02:37 AM
 */

public interface ModuleService extends CrudService<Module> {

	/**
	 * 查找子节点
	 * @param module
	 * @return
	 */
	public List<Map<String,Object>> findChildren(Module module);
	
	/**
	 * 查询子部门,带分页
	 * @param parentModuleId
	 * @param pageable
	 * @return
	 */
	public Page<Module> findByParentModuleId(String parentModuleId,Pageable pageable);
	
	/**
	 * 根据条件查询模块
	 * @param moduleName
	 * @param parentModuleId
	 * @return
	 */
	public Page<Module> findModules(String moduleName,String parentModuleId, Pageable pageable);
	
	/**
	 * 批量删除模块
	 * @param moduleIds
	 * @return
	 */
	public void deleteModules(List<String> moduleIds);
	
}
