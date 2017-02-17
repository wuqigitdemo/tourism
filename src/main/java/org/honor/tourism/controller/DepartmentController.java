package org.honor.tourism.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.honor.tourism.entity.Department;
import org.honor.tourism.entity.SysRole;
import org.honor.tourism.entity.SysUser;
import org.honor.tourism.service.DepartmentService;
import org.honor.tourism.service.SysUserService;
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
 * 部门Controller
 *
 */
@Controller
@RequestMapping("/Department")
public class DepartmentController {
	
	@Autowired 
	private DepartmentService service;
	
	@Autowired
	private SysUserService sysUserService;

	/**
	 * 获取部门
	 * @param page
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<Department> pageDepartment =  service.findAll(pageable);
		List<Department> rows = pageDepartment.getContent();
		Long total = service.count();
		return EasyuiResult.result(rows, total);
	}

	/**
	 * 获取部门
	 * @param page
	 * @return
	 */
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<Department> selectAll() {
		List<Department> DepartmentList =  service.findAll();
		return DepartmentList;
	}
	
	/**
	 * 新增和修改
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(@Valid Department department, BindingResult result) {
		if (result.hasErrors()) {//数据交验
			return EasyuiResult.result(result);
        }
		
		if (department.getParentDepartment().getId().equals("001")) {
			department.setParentDepartment(null);
		}
		
		Department returnDepartment = service.save(department);
		if (returnDepartment == null) {
			EasyuiResult.result(false, "添加失败");
		}
		return EasyuiResult.result(true);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(String id) {
		
		try {
			service.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return EasyuiResult.result(false,"该类别下有子类，无法删除。");
		}
		
		return EasyuiResult.result(true);
	}
	
	/**
	 * 查询部门，返回tree
	 * @param id
	 * @return
	 */
	@RequestMapping("/findTree")
	@ResponseBody
	public List<Map<String,Object>> findTree(String id) {
		
		List<Map<String,Object>> departments = new ArrayList<>();
		if (id == null || id.equals("")) {
			//查出部门整个森林
			departments = service.findChildren(null);
			
			//添加一个虚拟节点，所有部门
			Map<String, Object> deptMap = new HashMap<>();
			deptMap.put("id", "001");
			deptMap.put("departmentName", "所有部门");
			deptMap.put("children", departments);
			
			List<Map<String,Object>> departmentAll = new ArrayList<>();
			departmentAll.add(deptMap);
			return departmentAll;
		}else {
			Department department = service.findOne(id);
			return service.findChildren(department);
		}		
		
	}
	
	/**
	 * 查询后代部门中所有员工
	 * @param id
	 * @return
	 */
	@RequestMapping("/findProgenyUsers")
	@ResponseBody
	public List<SysUser> findProgenyUsers(String id,EasyuiPage page) {

		List<SysUser> users = new ArrayList<SysUser>();
		if (id == null || id.equals("")) {
			users = service.findUsers(null);
		}else {
			Department department = service.findOne(id);
			users = service.findUsers(department);
		}

		for (SysUser sysUser : users) {
			sysUser.setRoles(new ArrayList<SysRole>());
		}
		
		if (page.getRows() == null) {
			return users;
		}
		
		int startIndex = page.getPage();
		int endIndex = (startIndex + page.getRows() > users.size()) ? users.size() : (startIndex + page.getRows());
		List<SysUser> retUsers = new ArrayList<SysUser>();
		for (int i = startIndex; i < endIndex; i++) 
		{
			retUsers.add(users.get(i));
		}
		
		return users;
	}
	
	/**
	 * 根据条件查询部门，返回tree
	 * @param departmentName
	 * @param parentDepartmentId
	 * @param delFlag
	 * @return
	 */
	@RequestMapping("/findDepts")
	@ResponseBody
	public Map<String, Object> findDepts(String departmentName,String parentDepartmentId,String delFlag, EasyuiPage page) {

		if (parentDepartmentId.equals("001")) {
			parentDepartmentId = null;
		}
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<Department> pageList =  service.findDepts(departmentName, parentDepartmentId, delFlag,pageable);
		List<Department> rows = pageList.getContent();
		long total = pageList.getTotalElements();
		return EasyuiResult.result(rows, total);
	}

	/**
	 * 查询子部门
	 * @param parentDepartmentId
	 * @param page
	 * @return
	 */
	@RequestMapping("/findByParentDepartmentId")
	@ResponseBody
	public Map<String, Object> findByParentDepartmentId(String parentDepartmentId, EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<Department> pageDepartment =  service.findByParentDepartmentId(parentDepartmentId, pageable);
		List<Department> rows = pageDepartment.getContent();
		Long total = service.count();
		return EasyuiResult.result(rows, total);
	}
	
	/**
	 * 批量删除部门
	 * @param userIds
	 * @return
	 */
	@RequestMapping(value = "/deleteDepts",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteDepts(@RequestBody List<String> deptIds) {
		try {
			service.deleteDepts(deptIds);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("批量删除员工错误");
			e.printStackTrace();
			return EasyuiResult.result(false,"操作失败");
		}
		
		return EasyuiResult.result(true,"操作成功");
	}
	
	/**
	 * 查找单个部门详细信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findById",method = RequestMethod.POST)
	@ResponseBody
	public Department findById(String id) {
		
		Department dept = service.findById(id);
		return dept;
	}
	
	/**
	 * 导出部门excel表格
	 * @param deptId
	 * @return
	 */
	@RequestMapping("/outputDeptExcel")
	@ResponseBody
	public Map<String, Object> outputDeptExcel(String deptId,HttpServletResponse response) {

		try {
			service.outputDeptExcel(deptId, response);
		} catch (Exception e) {
			return EasyuiResult.result(false);
		}
		
		return EasyuiResult.result(true);
	}
	
	/**
	 * 导出部门pdf
	 * @param deptId
	 * @return
	 */
	@RequestMapping("/outputDeptPDF")
	@ResponseBody
	public Map<String, Object> outputDeptPDF(String deptId,HttpServletResponse response) {

		try {
			service.outputDeptPDF(deptId, response);
		} catch (Exception e) {
			return EasyuiResult.result(false);
		}
		
		return EasyuiResult.result(true);
	}
	
	/**
	 * 导出员工excel表格
	 * @param deptId
	 * @return
	 */
	@RequestMapping("/outputUsersExcel")
	@ResponseBody
	public Map<String, Object> outputUsersExcel(String deptId,HttpServletResponse response) {

		List<SysUser> users = new ArrayList<SysUser>();
		String fileName = "用户-所有用户.xls"; //文件名 
		
		if (deptId == null || deptId.equals("")) {
			users = service.findUsers(null);
		}else {
			Department department = service.findOne(deptId);
			users = service.findUsers(department);
			fileName = "用户-"+department.getDepartmentName()+".xls"; //文件名 
		}
		
		try {
			sysUserService.outputUsersExcel(fileName,users, response);
		} catch (Exception e) {
			return EasyuiResult.result(false);
		}
		
		return EasyuiResult.result(true);
	}
	
	/**
	 * 导出员工PDF
	 * @param deptId
	 * @return
	 */
	@RequestMapping("/outputUsersPDF")
	@ResponseBody
	public Map<String, Object> outputUsersPDF(String deptId,HttpServletResponse response) {

		List<SysUser> users = new ArrayList<SysUser>();
		String fileName = "用户-所有用户.pdf"; //文件名 
		
		if (deptId == null || deptId.equals("")) {
			users = service.findUsers(null);
		}else {
			Department department = service.findOne(deptId);
			users = service.findUsers(department);
			fileName = "用户-"+department.getDepartmentName()+".pdf"; //文件名 
		}
		
		try {
			sysUserService.outputUsersPDF(fileName, users, response);
		} catch (Exception e) {
			return EasyuiResult.result(false);
		}
		
		return EasyuiResult.result(true);
	}

}
