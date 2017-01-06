package org.honor.tourism.service;

import java.util.List;

import org.honor.tourism.entity.RouteTrip;

/**
 * 
 * @author 刘海 行程信息service
 */
public interface RouteTripService  {
	
	public void saveRouteTrip(List<RouteTrip> routeTrips, String routeId);
	
}
