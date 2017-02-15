package org.honor.tourism.controller;

import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.service.SelfSupportRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 订单
 * 
 * @author keiwu
 *
 */
@Controller
@RequestMapping("/Order")
public class OrderController {

	@Autowired 
	private SelfSupportRouteService selfSupportRouteService;

	@RequestMapping(value = "/booked")
	public String booked(ModelMap model, String routeId) {
		if (routeId != null && !"".equals(routeId)) {
			SelfSupportRoute selfSupportRoute = selfSupportRouteService.findRouteWithId(routeId);
			model.addAttribute("selfSupportRoute", selfSupportRoute);
		}
		return "/ProductBusinessManage/OrderBooked";
	}

}
