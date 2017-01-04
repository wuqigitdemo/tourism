package org.honor.tourism.service;

import java.util.List;

import org.honor.tourism.entity.SelfSupportRoute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SelfSupportRouteService extends CrudService<SelfSupportRoute> {

	public List<SelfSupportRoute> findByRouteBaseInfoRouteNameOrRouteBaseInfoOutPlaceOrRouteBaseInfoDestinationOrRouteBaseInfoRouteTypeListTypeName(String routeName, String outPlace, String destination, String typeName, Pageable pageable);
	
}
