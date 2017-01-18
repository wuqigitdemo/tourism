package org.honor.tourism.service;


import java.util.List;

import org.honor.tourism.entity.RouteDay;

public interface RouteDayService {
	
	public List<RouteDay> findAll();
	
	public Long count();
	
	public RouteDay saveRouteDay(RouteDay routeDay, String routeTripId);
	
	public RouteDay save(RouteDay routeDay);
	
	public void delete(String id);

	public List<RouteDay> selectedAll(String routeTripId);
	

}
