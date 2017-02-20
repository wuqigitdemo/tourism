package org.honor.tourism.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.honor.tourism.entity.Module;
import org.honor.tourism.entity.SysRole;
import org.honor.tourism.service.CrudService;
import org.honor.tourism.service.ModuleService;
import org.honor.tourism.util.EasyuiPage;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 作者:修罗大人
 * 日期:Feb 17, 2017
 * 时间:10:00:37 AM
 */
@Controller
@RequestMapping("/Module")
public class ModuleController extends CrudController<Module> {

	@Autowired
	private ModuleService service;
	
	@Autowired
	public ModuleController(CrudService<Module> service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 查询模块，返回tree
	 * @param id
	 * @return
	 */
	@RequestMapping("/findTree")
	@ResponseBody
	public List<Map<String,Object>> findTree(String id) {
		
		List<Map<String,Object>> modules = new ArrayList<>();
		if (id == null || id.equals("")) {
			//查出部门整个森林
			modules = service.findChildren(null);
			
			//添加一个虚拟节点，所有部门
			Map<String, Object> moduleMap = new HashMap<>();
			moduleMap.put("id", "001");
			moduleMap.put("moduleName", "所有模块");
			moduleMap.put("children", modules);
			
			List<Map<String,Object>> moduleAll = new ArrayList<>();
			moduleAll.add(moduleMap);
			return moduleAll;
		}else {
			Module module = service.findById(id);
			return service.findChildren(module);
		}		
		
	}
	
	/**
	 * 查询子模块
	 * @param parentDepartmentId
	 * @param page
	 * @return
	 */
	@RequestMapping("/findByParentModuleId")
	@ResponseBody
	public Map<String, Object> findByParentModuleId(String parentModuleId, EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<Module> pageModule =  service.findByParentModuleId(parentModuleId, pageable);
		List<Module> rows = pageModule.getContent();
		
		Long total = service.count();
		return EasyuiResult.result(rows, total);
	}
	
	/**
	 * 根据条件查询模块
	 * @param moduleName
	 * @param parentModuleId
	 * @return
	 */
	@RequestMapping("/findModules")
	@ResponseBody
	public Map<String, Object> findModules(String moduleName,String parentModuleId, EasyuiPage page) {

		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<Module> pageList =  service.findModules(moduleName, parentModuleId,pageable);
		List<Module> rows = pageList.getContent();
		long total = pageList.getTotalElements();
		return EasyuiResult.result(rows, total);
	}
	
	/**
	 * 批量删除模块
	 * @param moduleIds
	 * @return
	 */
	@RequestMapping(value = "/deleteModules",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteModules(@RequestBody List<String> moduleIds) {
		try {
			service.deleteModules(moduleIds);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("批量删除模块错误");
			e.printStackTrace();
			return EasyuiResult.result(false,"操作失败");
		}
		
		return EasyuiResult.result(true,"操作成功");
	}
	
	@Override
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<Module> t =  service.findAll(pageable);
		List<Module> rows = t.getContent();
		
		for (Module module : rows) {
			module.setSysRoleList(new ArrayList<SysRole>());
		}
		
		Long total = service.count();
		return EasyuiResult.result(rows, total);
	}
	
	
	/**
	 * 新增和修改
	 * @return
	 */
	@Override
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(@Valid Module module, BindingResult result) {
		if (result.hasErrors()) {//数据交验
			return EasyuiResult.result(result);
        }
		
		if (module.getParentModule().getId().equals("")) {
			module.setParentModule(null);
		}
		
		Module retModule = service.save(module);
		if (retModule == null) {
			EasyuiResult.result(false, "添加失败");
		}
		return EasyuiResult.result(true);
	}
	
	/**
	 * 根据moduleId查找模块角色
	 * @param moduleId
	 * @return
	 */
	@RequestMapping("/findRolesById")
	@ResponseBody
	public List<SysRole> findRolesById(String moduleId) {
		
		Module module = service.findById(moduleId);
		List<SysRole> roles = module.getSysRoleList();
		return roles;
	}
	
	/**
	 * 查询单条模块信息
	 * @param moduleId
	 * @return
	 */
	@RequestMapping("/findOne")
	@ResponseBody
	public Module findOne(String moduleId) {
		return service.findById(moduleId);
	}
	
}
