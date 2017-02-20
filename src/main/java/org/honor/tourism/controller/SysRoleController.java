package org.honor.tourism.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.Module;
import org.honor.tourism.entity.SysRole;
import org.honor.tourism.entity.SysUser;
import org.honor.tourism.service.CrudService;
import org.honor.tourism.service.SysRoleService;
import org.honor.tourism.util.EasyuiPage;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.ls.LSInput;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.fabric.xmlrpc.base.Array;

/**
 * 作者:修罗大人
 * 日期:Feb 14, 2017
 * 时间:4:45:43 PM
 * 角色controller
 */
@Controller
@RequestMapping("/SysRole")
public class SysRoleController extends CrudController<SysRole> {

	@Autowired
	private SysRoleService service;
	
	@Autowired
	public SysRoleController(CrudService<SysRole> service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 批量删除角色
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="deleteRoles",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteRoles(@RequestBody List<String> ids) {
		
		try {
			service.deleteRoles(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return EasyuiResult.result(false,"删除失败");
		}
		
		return EasyuiResult.result(true,"删除成功");
	}
	
	/**
	 * 查询角色
	 * @param roleName
	 * @return
	 */
	@RequestMapping("/findRoles")
	@ResponseBody
	public Map<String, Object> findRoles(String roleName,EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<SysRole> t = service.findRoles(roleName, pageable);
		List<SysRole> rows = t.getContent();
		
		for (SysRole sysRole : rows) {
			List<SysUser> sysUsers = sysRole.getUsers();
			for (SysUser sysUser : sysUsers) {
				sysUser.setRoles(new ArrayList<SysRole>());
			}
			List<Module> modules = sysRole.getModuleList();
			for (Module module : modules) {
				module.setSysRoleList(new ArrayList<SysRole>());
			}
		}
		
		long total = t.getTotalElements();
		return EasyuiResult.result(rows,total);
	}
	
	/**
	 * 根据id查找角色详情
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/findById")
	@ResponseBody
	public SysRole findById(String roleId) {
		SysRole sysRole = service.findOne(roleId);

		List<SysUser> users = sysRole.getUsers();
		for (SysUser sysUser : users) {
			sysUser.setRoles(new ArrayList<SysRole>());
		}
		List<Module> modules = sysRole.getModuleList();
		for (Module module : modules) {
			module.setSysRoleList(new ArrayList<SysRole>());
		}
		
		return sysRole;
	}
	
	/**
	 * 查询全部角色返回tree
	 * @return
	 */
	@RequestMapping("/findTree")
	@ResponseBody
	public List<SysRole> findTree() {
		
		List<SysRole> sysRoles = service.findTree();
		
		for (SysRole sysRole : sysRoles) {
			sysRole.setUsers(null);
			sysRole.setModuleList(null);
		}
		
		return sysRoles;
	}
	
	@Override
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<SysRole> t =  service.findAll(pageable);
		List<SysRole> rows = t.getContent();
		
		for (SysRole sysRole : rows) {
			List<SysUser> sysUsers = sysRole.getUsers();
			for (SysUser sysUser : sysUsers) {
				sysUser.setRoles(new ArrayList<SysRole>());
			}
			List<Module> modules = sysRole.getModuleList();
			for (Module module : modules) {
				module.setSysRoleList(new ArrayList<SysRole>());
			}
		}
		
		Long total = service.count();
		return EasyuiResult.result(rows, total);
	}
	
	/**
	 * 设置用户角色
	 * @param userId
	 * @param roleCodes
	 * @return
	 */
	@RequestMapping("/setUserRoles")
	@ResponseBody
	public Map<String, Object> setUserRoles(String userId,String roleCodes) {
		
		String[] roleIds = roleCodes.split("\\|");

		try {
			service.setUserRoles(userId, roleIds);
		} catch (Exception e) {
			e.printStackTrace();
			return EasyuiResult.result(false,"操作失败");
		}
		
		return EasyuiResult.result(true,"操作成功");
	}
	
	/** 设置模块角色
	 * @param moduleId
	 * @param roleCodes
	 * @return
	 */
	@RequestMapping("/setModuleRoles")
	@ResponseBody
	public Map<String, Object> setModuleRoles(String moduleId,String roleCodes) {
		
		String[] roleIds = roleCodes.split("\\|");

		try {
			service.setModuleRoles(moduleId, roleIds);
		} catch (Exception e) {
			e.printStackTrace();
			return EasyuiResult.result(false,"操作失败");
		}
		
		return EasyuiResult.result(true,"操作成功");
	}
	
	/** 设置角色模块
	 * @param roleId
	 * @param roleCodes
	 * @return
	 */
	@RequestMapping("/setRoleModules")
	@ResponseBody
	public Map<String, Object> setRoleModules(String roleId,String moduleCodes) {
		
		String[] moduleIds = moduleCodes.split("\\|");
		
		try {
			service.setRoleModules(roleId, moduleIds);
		} catch (Exception e) {
			e.printStackTrace();
			return EasyuiResult.result(false,"操作失败");
		}
		
		return EasyuiResult.result(true,"操作成功");
	}
	
	/**
	 * 设置角色用户
	 * @param userId
	 * @param roleCodes
	 * @param roles
	 * @return
	 */
	@RequestMapping("/setRoleUsers")
	@ResponseBody
	public Map<String, Object> setRoleUsers(String userIds,String roleId) {
		
		String[] userCodes = userIds.split("\\|");

		try {
			service.setRoleUsers(userCodes, roleId);
		} catch (Exception e) {
			e.printStackTrace();
			return EasyuiResult.result(false,"操作失败");
		}
		
		return EasyuiResult.result(true,"操作成功");
	}
	
	/**
	 * 获取单条角色信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	@ResponseBody
	public SysRole findOne(String id) {
		SysRole role = service.findOne(id);
		
		List<SysUser> users = role.getUsers();
		for (SysUser sysUser : users) {
			sysUser.setRoles(new ArrayList<SysRole>());
		}
		
		return role;
	}
	
	/**
	 * 查询角色的员工
	 * @param id
	 * @return
	 */
	@RequestMapping("/findUsersById")
	@ResponseBody
	public List<SysUser> findUsersById(String id) {
		SysRole sysRole = service.findOne(id);
		List<SysUser> users = sysRole.getUsers();
		
		for (SysUser sysUser : users) {
			sysUser.setRoles(new ArrayList<SysRole>());
		}
		
		return users;
	}
	
	/**
	 * 查询角色的模块
	 * @param id
	 * @return
	 */
	@RequestMapping("/findModulesById")
	@ResponseBody
	public List<Module> findModulesById(String id) {
		List<Module> modules = service.findOne(id).getModuleList();
		return modules;
	}
	
}
