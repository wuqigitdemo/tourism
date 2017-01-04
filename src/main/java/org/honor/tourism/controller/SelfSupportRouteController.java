package org.honor.tourism.controller;

import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.service.CrudService;
import org.honor.tourism.service.SelfSupportRouteService;
import org.honor.tourism.util.EasyuiPage;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	private SelfSupportRouteService service;

	@Autowired
	public SelfSupportRouteService selfSupportRouteService;
	
	@Autowired
	public SelfSupportRouteController(CrudService<SelfSupportRoute> service) {
		super(service);
	}

	@RequestMapping(value = "/routeUpdateHtml",method = RequestMethod.POST)
	public String routeUpdateHtml (ModelMap model, String routeId) {
		
		SelfSupportRoute selfSupportRoute = selfSupportRouteService.findRouteWithId(routeId);
		
		model.addAttribute("selfSupportRoute", selfSupportRoute);
		return "/OtherTypeManage/Tabs";
	}
	
	@RequestMapping("/findByPar")
	@ResponseBody
	public Map<String, Object> findByPar(String routeName, String outPlace, String destination, String typeName, EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<SelfSupportRoute> pageList =  selfSupportRouteService.findByRouteBaseInfoRouteNameOrRouteBaseInfoOutPlaceOrRouteBaseInfoDestinationOrRouteBaseInfoRouteTypeListTypeName(routeName, outPlace, destination, typeName, pageable);
		List<SelfSupportRoute> rows = pageList.getContent();
		long total = pageList.getTotalElements();
		return EasyuiResult.result(rows, total);
	}
}
