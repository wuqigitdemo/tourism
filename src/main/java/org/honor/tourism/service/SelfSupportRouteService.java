package org.honor.tourism.service;

import org.honor.tourism.entity.SelfSupportRoute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * 作者:修罗大人
 * 日期:Jan 4, 2017
 * 时间:10:29:36 AM
 * 自营线路Service
 */
public interface SelfSupportRouteService extends CrudService<SelfSupportRoute> {

	public SelfSupportRoute findRouteWithId (String routeId);
	public Page<SelfSupportRoute> findByRouteBaseInfoRouteNameOrRouteBaseInfoOutPlaceOrRouteBaseInfoDestinationOrRouteBaseInfoRouteTypeListTypeName(String routeName, String outPlace, String destination, String typeName, Pageable pageable);
	
}
