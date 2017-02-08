package org.honor.tourism.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.honor.tourism.entity.Department;
import org.honor.tourism.entity.RouteCategory;
import org.honor.tourism.entity.RouteType;
import org.honor.tourism.service.DepartmentService;
import org.honor.tourism.service.RouteCategoryService;
import org.honor.tourism.service.RouteTypeService;
import org.honor.tourism.util.EasyuiPage;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}
