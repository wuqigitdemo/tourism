package org.honor.tourism.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.Department;
import org.honor.tourism.entity.Module;
import org.honor.tourism.repository.ModuleRepository;
import org.honor.tourism.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * 作者:修罗大人
 * 日期:Feb 17, 2017
 * 时间:10:03:49 AM
 */
@Service
public class ModuleServiceImpl extends CrudServiceImpl<Module> implements ModuleService {

	@Autowired
	private ModuleRepository repository;
	
	@Autowired
	public ModuleServiceImpl(JpaRepository<Module, String> repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 查找子节点
	 * @param module
	 * @return List<Map<String,Object>>
	 */
	public List<Map<String,Object>> findChildren(Module module) {
		
		List<Map<String,Object>> retDepts = new ArrayList<Map<String,Object>>();
		List<Module> modules = new ArrayList<>();
				
		//根节点
		if (module == null) {
			modules = repository.findByParentModuleId(null);
		}else {
			modules = repository.findByParentModuleId(module.getId());
		}
		
		if (modules.size() != 0) 
		{
			for (Module moduleTemp : modules) {
				Map<String, Object> deptMap = new HashMap<>();
				deptMap.put("id", moduleTemp.getId());
				deptMap.put("moduleName", moduleTemp.getModuleName());
				
				List<Map<String, Object>> children = findChildren(moduleTemp);
				if (children.size() != 0) {
					//deptMap.put("children", children);
					deptMap.put("state","closed");
				}
				
				retDepts.add(deptMap);
			}
		}
		
		return retDepts;
	}

	/**
	 * 查询子部门
	 * @param parentModuleId
	 * @param pageable
	 * @return
	 */
	public Page<Module> findByParentModuleId(String parentModuleId,Pageable pageable)
	{
		List<Module> modules = repository.findByParentModuleId(parentModuleId);
		
		int startIndex = pageable.getPageNumber() * pageable.getPageSize();
		int pageSize = pageable.getPageSize();
		int total = modules.size();
		int endIndex = (startIndex + pageSize) > total ? total : (startIndex + pageSize);
		
		List<Module> moduleTemp = new ArrayList<Module>();
		for (int i = startIndex; i < endIndex; i++) 
		{
			moduleTemp.add(modules.get(i));
		}
		
		Page<Module> page = new PageImpl<Module>(moduleTemp, pageable, total);
		
		return page;
	}

	/**
	 * 根据条件查询部门
	 * @param moduleName
	 * @param parentModuleId
	 * @return
	 */
	public Page<Module> findModules(String moduleName,String parentModuleId, Pageable pageable)
	{
		return repository.findModules(moduleName, parentModuleId,pageable);
	}
	
	/**
	 * 批量删除模块
	 * @param moduleIds
	 * @return
	 */
	public void deleteModules(List<String> moduleIds)
	{
		for (String id : moduleIds) {
			
			Module module = repository.findOne(id);
			
			if (module != null) {
				deleteChildren(module);
			}
		}
	}
	
	/**
	 * 删除子节点
	 * @param module
	 * @return List<Map<String,Object>>
	 */
	public void deleteChildren(Module module) {

		List<Module> modules = new ArrayList<>();
				
		//根节点
		if (module == null) {
			modules = repository.findByParentModuleId(null);
		}else {
			modules = repository.findByParentModuleId(module.getId());
		}
		
		if (modules.size() != 0) 
		{
			for (Module modulesTemp : modules) 
			{
				deleteChildren(modulesTemp);
				repository.delete(modulesTemp);
			}
			repository.delete(module);
		}else {
			repository.delete(module);
		}
	}
	
}
