package org.honor.tourism.controller;

import java.util.Map;

import org.honor.tourism.service.SelfSupportRouteInsuraceManagementService;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 作者:修罗大人
 * 日期:Jan 3, 2017
 * 时间:2:06:35 PM
 * 自营线路保险管理Controller
 */

@Controller
@RequestMapping("/SelfSupportRouteInsuranceManagement")
public class SelfSupportRouteInsuranceManagementController {

	@Autowired
	public SelfSupportRouteInsuraceManagementService selfSupportRouteInsuraceManagementService;
	
	/**
	 * 保存保险信息
	 * @param insuranceManagement
	 * @param result
	 * @return
	 */
	@RequestMapping("/addInsuranceManagement")
	@ResponseBody
	public Map<String, Object> addInsuranceManagement(String insuranceManagementId,String routeId) {
		
		return selfSupportRouteInsuraceManagementService.addInsuranceManagement(insuranceManagementId,routeId);
	}
}
