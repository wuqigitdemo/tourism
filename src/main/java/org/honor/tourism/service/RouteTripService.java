package org.honor.tourism.service;



import org.honor.tourism.entity.RouteTrip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @author 刘海 行程信息service
 */
public interface RouteTripService  {
	
	public Page<RouteTrip> findAll(Pageable pageable,String id);
	
	public Long count();
	
	public RouteTrip saveRouteTrip(RouteTrip routeTrip, String routeId);
	
	public RouteTrip save(RouteTrip routeTrip);
	
	public void delete(String id);
	
}
