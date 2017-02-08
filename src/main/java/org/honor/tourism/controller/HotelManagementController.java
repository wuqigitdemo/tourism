package org.honor.tourism.controller;

import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.HotelManagement;
import org.honor.tourism.entity.PriceInventory;
import org.honor.tourism.entity.RouteTrip;
import org.honor.tourism.entity.RouteType;
import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.service.CrudService;
import org.honor.tourism.service.HotelManagementService;
import org.honor.tourism.service.RouteTypeService;
import org.honor.tourism.service.SelfSupportRouteService;
import org.honor.tourism.util.EasyuiPage;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 酒店管理
 */
@Controller
@RequestMapping("/HotelManagement")
public class HotelManagementController extends CrudController<HotelManagement> {

	@Autowired
	public HotelManagementService hotelManagementService;
	
	@Autowired
	public HotelManagementController(CrudService<HotelManagement> service) {
		super(service);
	}
	
	/**
	 * 添加页面
	 * @param model
	 * @param routeId
	 * @return
	 */
	@RequestMapping(value = "/hotelManagementAddHtml",method = RequestMethod.GET)
	public String hotelManagementAddHtml (ModelMap model, String id) {
		
		HotelManagement hotelManagement = hotelManagementService.findId(id);
		
		model.addAttribute("hotelManagement", hotelManagement);
		return "/ProductBusinessManage/RouteManage/HotelManagementAdd";
	}
	
	/**
	 * 修改线路价格库存页面
	 * @param model
	 * @param routeId
	 * @return
	 */
	/*
	@RequestMapping(value = "/routePriceInventoryUpdateHtml",method = RequestMethod.GET)
	public String routePriceInventoryUpdateHtml (ModelMap model, String routeId) {
		
		SelfSupportRoute selfSupportRoute = selfSupportRouteService.findRouteWithId(routeId);
		
		model.addAttribute("selfSupportRoute", selfSupportRoute);
		return "/ProductBusinessManage/RouteManage/PriceInventoryUpdate";
	}*/
	
	/**
	 * 查看线路价格库存页面
	 * @param model
	 * @param routeId
	 * @return
	 */
	/*@RequestMapping(value = "/routePriceInventoryViewHtml",method = RequestMethod.GET)
	public String routePriceInventoryViewHtml (ModelMap model, String routeId) {
		
		SelfSupportRoute selfSupportRoute = selfSupportRouteService.findRouteWithId(routeId);
		
		model.addAttribute("selfSupportRoute", selfSupportRoute);
		return "/ProductBusinessManage/RouteManage/PriceInventoryView";
	}*/
	
	/**
	 * 多个删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/deletes")
	@ResponseBody
	public Map<String, Object> delete(@RequestBody List<HotelManagement> ids) {
		hotelManagementService.delete(ids);
		return EasyuiResult.result(true);
	}
	
}
