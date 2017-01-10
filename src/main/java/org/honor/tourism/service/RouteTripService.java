package org.honor.tourism.service;



import org.honor.tourism.entity.RouteDay;
import org.honor.tourism.entity.RouteTrip;

/**
 * 
 * @author 刘海 行程信息service
 */
public interface RouteTripService  {
	
	public void saveRouteTrip(RouteTrip routeTrip,RouteDay routeDay, String routeId);
	
}
