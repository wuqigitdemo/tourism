package org.honor.tourism.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.honor.tourism.entity.PriceInventory;
import org.honor.tourism.entity.RouteTrip;
import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.service.CrudService;
import org.honor.tourism.service.RouteTypeService;
import org.honor.tourism.service.SelfSupportRouteService;
import org.honor.tourism.util.EasyuiPage;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/SelfSupportRoute")
/**
 * 作者:修罗大人
 * 日期:Jan 4, 2017
 * 时间:10:29:36 AM
 * 自营线路Controller
 */
public class SelfSupportRouteController extends CrudController<SelfSupportRoute> {

	@Autowired
	public SelfSupportRouteService selfSupportRouteService;
	
	@Autowired
	public RouteTypeService routeTypeService;
	
	@Autowired
	public SelfSupportRouteController(CrudService<SelfSupportRoute> service) {
		super(service);
	}
	
	/**
	 * 添加线路价格库存页面
	 * @param model
	 * @param routeId
	 * @return
	 */
	@RequestMapping(value = "/routePriceInventoryAddHtml",method = RequestMethod.GET)
	public String routePriceInventoryAddHtml (ModelMap model, String routeId) {
		
		SelfSupportRoute selfSupportRoute = selfSupportRouteService.findRouteWithId(routeId);
		
		model.addAttribute("selfSupportRoute", selfSupportRoute);
		return "/ProductBusinessManage/RouteManage/PriceInventory";
	}
	
	/**
	 * 修改线路价格库存页面
	 * @param model
	 * @param routeId
	 * @return
	 */
	@RequestMapping(value = "/routePriceInventoryUpdateHtml",method = RequestMethod.GET)
	public String routePriceInventoryUpdateHtml (ModelMap model, String routeId) {
		
		SelfSupportRoute selfSupportRoute = selfSupportRouteService.findRouteWithId(routeId);
		
		model.addAttribute("selfSupportRoute", selfSupportRoute);
		return "/ProductBusinessManage/RouteManage/PriceInventoryUpdate";
	}
	
	/**
	 * 查看线路价格库存页面
	 * @param model
	 * @param routeId
	 * @return
	 */
	@RequestMapping(value = "/routePriceInventoryViewHtml",method = RequestMethod.GET)
	public String routePriceInventoryViewHtml (ModelMap model, String routeId) {
		
		SelfSupportRoute selfSupportRoute = selfSupportRouteService.findRouteWithId(routeId);
		
		model.addAttribute("selfSupportRoute", selfSupportRoute);
		return "/ProductBusinessManage/RouteManage/PriceInventoryView";
	}
	
	/**
	 * 添加线路其他信息页面
	 * @param model
	 * @param routeId
	 * @return
	 */
	@RequestMapping(value = "/routeOtherInfoAddHtml",method = RequestMethod.GET)
	public String routeOtherInfoAddHtml (ModelMap model, String routeId) {
		
		SelfSupportRoute selfSupportRoute = selfSupportRouteService.findRouteWithId(routeId);
		
		model.addAttribute("selfSupportRoute", selfSupportRoute);
		return "/ProductBusinessManage/RouteManage/OtherInfo";
	}
	
	/**
	 * 修改线路其他信息页面
	 * @param model
	 * @param routeId
	 * @return
	 */
	@RequestMapping(value = "/routeOtherInfoUpdateHtml",method = RequestMethod.GET)
	public String routeOtherInfoUpdateHtml (ModelMap model, String routeId) {
		
		SelfSupportRoute selfSupportRoute = selfSupportRouteService.findRouteWithId(routeId);
		
		model.addAttribute("selfSupportRoute", selfSupportRoute);
		return "/ProductBusinessManage/RouteManage/OtherInfoUpdate";
	}
	
	/**
	 * 查看线路其他信息页面
	 * @param model
	 * @param routeId
	 * @return
	 */
	@RequestMapping(value = "/routeOtherInfoViewHtml",method = RequestMethod.GET)
	public String routeOtherInfoViewHtml (ModelMap model, String routeId) {
		
		SelfSupportRoute selfSupportRoute = selfSupportRouteService.findRouteWithId(routeId);
		
		model.addAttribute("selfSupportRoute", selfSupportRoute);
		return "/ProductBusinessManage/RouteManage/OtherInfoView";
	}
	
	/**
	 * 添加线路保险页面
	 * @param model
	 * @param routeId
	 * @return
	 */
	@RequestMapping(value = "/routeRouteInsuranceAddHtml",method = RequestMethod.GET)
	public String routeRouteInsuranceAddHtml (ModelMap model, String routeId) {
		
		SelfSupportRoute selfSupportRoute = selfSupportRouteService.findRouteWithId(routeId);
		
		model.addAttribute("selfSupportRoute", selfSupportRoute);
		return "/ProductBusinessManage/RouteManage/RouteInsurance";
	}
	
	/**
	 * 修改线路保险页面
	 * @param model
	 * @param routeId
	 * @return
	 */
	@RequestMapping(value = "/routeRouteInsuranceUpdateHtml",method = RequestMethod.GET)
	public String routeRouteInsuranceUpdateHtml (ModelMap model, String routeId) {
		
		SelfSupportRoute selfSupportRoute = selfSupportRouteService.findRouteWithId(routeId);
		
		model.addAttribute("selfSupportRoute", selfSupportRoute);
		return "/ProductBusinessManage/RouteManage/RouteInsuranceUpdate";
	}
	
	/**
	 * 查看线路保险页面
	 * @param model
	 * @param routeId
	 * @return
	 */
	@RequestMapping(value = "/routeRouteInsuranceViewHtml",method = RequestMethod.GET)
	public String routeRouteInsuranceViewHtml (ModelMap model, String routeId) {
		
		SelfSupportRoute selfSupportRoute = selfSupportRouteService.findRouteWithId(routeId);
		
		model.addAttribute("selfSupportRoute", selfSupportRoute);
		return "/ProductBusinessManage/RouteManage/RouteInsuranceView";
	}
	
	@RequestMapping("/findByPar")
	@ResponseBody
	public Map<String, Object> findByPar(String routeName, String outPlace, String destination, String typeName, Integer startDays, Integer endDays, EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<SelfSupportRoute> pageList =  selfSupportRouteService.findByRouteBaseInfoRouteNameOrRouteBaseInfoOutPlaceOrRouteBaseInfoDestinationOrRouteBaseInfoRouteTypeListTypeName(routeName, outPlace, destination, typeName, startDays, endDays, pageable);
		List<SelfSupportRoute> rows = pageList.getContent();
		for (SelfSupportRoute selfSupportRoute : rows) {
			List<RouteTrip> list = selfSupportRoute.getRouteTripList();
			for (RouteTrip routeTrip : list) {
				routeTrip.setSelfSupportRoute(null);
			}
		}
		long total = pageList.getTotalElements();
		return EasyuiResult.result(rows, total);
	}
	
	/**
	 * 查询线路全部价格库存(带分页)
	 * @param page
	 * @param routeId
	 * @return
	 */
	@RequestMapping(value = "findPriceInventorysWithRouteId",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findPriceInventorysWithRouteId(EasyuiPage page,String routeId) {
		List<PriceInventory> priceInventories = selfSupportRouteService.findPriceInventorysWithRouteId(page,routeId);
		Long total = (long)selfSupportRouteService.priceInventorieCount(routeId);
		return EasyuiResult.result(priceInventories, total);
	}
	
	/**
	 * 多个删除多个
	 * @param id
	 * @return
	 */
	@RequestMapping("/deletes")
	@ResponseBody
	public Map<String, Object> delete(@RequestBody List<SelfSupportRoute> ids) {
		selfSupportRouteService.delete(ids);
		return EasyuiResult.result(true);
	}
	
}
