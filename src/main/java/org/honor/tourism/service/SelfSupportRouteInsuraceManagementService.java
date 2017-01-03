package org.honor.tourism.service;

import java.util.Map;

/**
 * 作者:修罗大人
 * 日期:Jan 3, 2017
 * 时间:2:50:26 PM
 * 自营线路保险管理Service
 */

public interface SelfSupportRouteInsuraceManagementService {
	
	/**
	 * 添加保险
	 * @param imId
	 * @param routeId
	 * @return
	 */
	public Map<String, Object> addInsuranceManagement(String imId,String routeId);
}
