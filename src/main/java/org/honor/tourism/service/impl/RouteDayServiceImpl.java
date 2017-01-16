package org.honor.tourism.service.impl;

import java.util.List;

import org.honor.tourism.entity.RouteDay;
import org.honor.tourism.entity.RouteTrip;
import org.honor.tourism.repository.RouteDayRepository;
import org.honor.tourism.repository.RouteTripRepository;
import org.honor.tourism.service.RouteDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 日程信息ServiceImpl
 * @author 刘海
 *
 */
@Service
public class RouteDayServiceImpl implements RouteDayService{
	
	@Autowired
	private RouteTripRepository routeTripRepository;
	
	@Autowired
	private RouteDayRepository routeDayRepository;

	@Override
	public List<RouteDay> findAll() {
		return routeDayRepository.findAll();
	}

	@Override
	public Long count() {
		return null;
	}

	@Override
	public RouteDay saveRouteDay(RouteDay routeDay, String routeTripId) {
		RouteTrip routeTrip = routeTripRepository.findOne(routeTripId);
		routeTrip.getRouteDayList().add(routeDay);
		return routeDayRepository.save(routeDay);
	}

	@Override
	public RouteDay save(RouteDay routeDay) {
		return routeDayRepository.save(routeDay);
	}

	@Override
	public void delete(String id) {
		routeDayRepository.delete(id);
	}

	@Override
	public List<RouteDay> selectedAll(String routeTripId) {
		RouteTrip routeTrip = routeTripRepository.findOne(routeTripId);
		return routeTrip.getRouteDayList();
	}

}
