package org.honor.tourism.service;

import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.InsuranceManagement;
import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.util.EasyuiPage;

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
	
	/**
	 * 删除保险
	 * @param imId
	 * @param routeId
	 * @return
	 */
	public SelfSupportRoute deleteInsuranceManagement(String imId,String routeId);
	
	/**
	 * 查询线路保险
	 * @param routeId
	 * @return
	 */
	public List<InsuranceManagement> findList(EasyuiPage page,String routeId);
	
	/**
	 * 线路中保险个数
	 * @param routeId
	 * @return
	 */
	public Integer imCount(String routeId);
}
