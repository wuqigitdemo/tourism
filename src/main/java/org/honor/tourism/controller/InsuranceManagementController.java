package org.honor.tourism.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.honor.tourism.entity.InsuranceManagement;
import org.honor.tourism.entity.InsuranceType;
import org.honor.tourism.entity.RouteCategory;
import org.honor.tourism.service.InsuranceManagementService;
import org.honor.tourism.service.InsuranceTypeService;
import org.honor.tourism.service.RouteCategoryService;
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
 * 保险管理Controller
 *
 */
@Controller
@RequestMapping("/InsuranceManagement")
public class InsuranceManagementController {
	
	@Autowired 
	private InsuranceManagementService service;
	
	@Autowired 
	private InsuranceTypeService insuranceTypeService;
	

	/**
	 * 获取保险
	 * @param page
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<InsuranceManagement> pageInsuranceManagement =  service.findAll(pageable);
		List<InsuranceManagement> rows = pageInsuranceManagement.getContent();
		Long total = service.count();
		return EasyuiResult.result(rows, total);
	}

	/**
	 * 新增和修改保险管理
	 * @param RouteCategory
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(@Valid InsuranceManagement insuranceManagement, BindingResult result) {
		if (result.hasErrors()) {//数据交验
			return EasyuiResult.result(result);
        }
		InsuranceManagement returnInsuranceManagement = service.save(insuranceManagement);
		if (returnInsuranceManagement == null) {
			EasyuiResult.result(false, "添加失败");
		}
		return EasyuiResult.result(true);
	}
	
	/**
	 * 获取保险类型
	 * @param page
	 * @return
	 */
	@RequestMapping("/selectType")
	@ResponseBody
	public List<InsuranceType> selectType() {
		List<InsuranceType> insuranceType =  insuranceTypeService.findAll();
		return insuranceType;
	}
	
	/**
	 * 删除保险管理
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(String id) {
		service.delete(id);
		return EasyuiResult.result(true);
	}
	
	/**
	 * 获取单条保险详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	@ResponseBody
	public Map<String, Object> findOne(String id) {
		List<InsuranceManagement> rows = service.findOne(id);
		Long total = (long)rows.size();
		return EasyuiResult.result(rows,total);
	}
}
