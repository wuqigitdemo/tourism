package org.honor.tourism.service.impl;

import java.util.List;

import org.honor.tourism.entity.RouteTrip;
import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.repository.SelfSupportRouteRepository;
import org.honor.tourism.service.RouteTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 刘海 行程信息ServiceImpl
 */
@Service
public class RouteTripServiceImpl implements RouteTripService {

	@Autowired
	private SelfSupportRouteRepository selfSupportRouteRepository;

	@Override
	public void saveRouteTrip(List<RouteTrip> routeTrips, String routeId) {

		// 将库存保存到线路
		SelfSupportRoute selfSupportRoute = selfSupportRouteRepository.findOne(routeId);
		selfSupportRoute.setRouteTripList(routeTrips);
		selfSupportRouteRepository.save(selfSupportRoute);
	}
}
