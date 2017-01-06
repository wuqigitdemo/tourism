package org.honor.tourism.controller;

import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.InsuranceManagement;
import org.honor.tourism.service.SelfSupportRouteInsuraceManagementService;
import org.honor.tourism.util.EasyuiPage;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value = "/addInsuranceManagement",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> addInsuranceManagement(String insuranceManagementId,String routeId) {
		
		return selfSupportRouteInsuraceManagementService.addInsuranceManagement(insuranceManagementId,routeId);
	}
	
	/**
	 * 删除保险
	 * @param insuranceManagementId
	 * @param routeId
	 * @return
	 */
	@RequestMapping(value = "/deleteInsuranceManagement",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteInsuranceManagement(String insuranceManagementId,String routeId) {
		
		try {
			selfSupportRouteInsuraceManagementService.deleteInsuranceManagement(insuranceManagementId,routeId);
		} catch (Exception e) {
			e.printStackTrace();
			return EasyuiResult.result(false,"操作失败");
		}
		
		return EasyuiResult.result(true,"操作成功");
	}
	
	/**
	 * 查询线路全部保险(带分页)
	 * @param page
	 * @param routeId
	 * @return
	 */
	@RequestMapping("/findList")
	@ResponseBody
	public Map<String, Object> findList(EasyuiPage page,String routeId) {
		
		List<InsuranceManagement> rows = selfSupportRouteInsuraceManagementService.findList(page,routeId);
		Long total = (long) selfSupportRouteInsuraceManagementService.imCount(routeId);
		
		return EasyuiResult.result(rows,total);
	}
}
