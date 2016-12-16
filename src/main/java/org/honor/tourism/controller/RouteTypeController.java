package org.honor.tourism.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.honor.tourism.entity.RouteCategory;
import org.honor.tourism.entity.RouteType;
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
 * 线路类别Controller
 * @author 修罗
 *
 */
@Controller
@RequestMapping("/RouteType")
public class RouteTypeController {
	
	@Autowired 
	private RouteTypeService service;

	@Autowired
	RouteCategoryService routeCategoryService; 
	
	/**
	 * 获取线路类别
	 * @param page
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<RouteType> pageRouteType =  service.findAll(pageable);
		List<RouteType> rows = pageRouteType.getContent();
		Long total = service.count();
		return EasyuiResult.result(rows, total);
	}

	/**
	 * 获取线路类别
	 * @param page
	 * @return
	 */
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<RouteType> selectAll() {
		List<RouteType> routeTypeList =  service.findAll();
		return routeTypeList;
	}
	
	/**
	 * 获取线路类型
	 * @param page
	 * @return
	 */
	@RequestMapping("/selectCategory")
	@ResponseBody
	public List<RouteCategory> selectCategory() {
		Pageable pageable = new PageRequest(0, 100000);
		Page<RouteCategory> routeCategory =  routeCategoryService.findAll(pageable);
		List<RouteCategory> rows = routeCategory.getContent();
		return rows;
	}
	
	/**
	 * 新增和修改线路类别
	 * @param tourismTheme
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(@Valid RouteType routeType, BindingResult result) {
		if (result.hasErrors()) {//数据交验
			return EasyuiResult.result(result);
        }
		RouteType returnRouteType = service.save(routeType);
		if (returnRouteType == null) {
			EasyuiResult.result(false, "添加失败");
		}
		return EasyuiResult.result(true);
	}
	
	/**
	 * 删除线路类别
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(String id) {
		service.delete(id);
		return EasyuiResult.result(true);
	}
	
}
