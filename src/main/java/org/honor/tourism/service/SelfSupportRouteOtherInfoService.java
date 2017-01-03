package org.honor.tourism.service;

import java.util.Map;

import org.honor.tourism.entity.SelfSupportRouteOtherInfo;

/**
 * 作者:修罗大人
 * 日期:Dec 28, 2016
 * 时间:10:37:43 AM
 * 其他信息service
 */
public interface SelfSupportRouteOtherInfoService extends CrudService<SelfSupportRouteOtherInfo> {
	
	/**
	 * 保存其他信息
	 * @param selfSupportRouteOtherInfo
	 * @param routeId
	 * @return
	 */
	public Map<String, Object> saveOtherInfo(SelfSupportRouteOtherInfo selfSupportRouteOtherInfo,String routeId);
}
