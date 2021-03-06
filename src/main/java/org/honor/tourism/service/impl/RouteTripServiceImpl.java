package org.honor.tourism.service.impl;


import org.honor.tourism.entity.RouteTrip;
import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.repository.RouteTripRepository;
import org.honor.tourism.repository.SelfSupportRouteRepository;
import org.honor.tourism.service.RouteTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 刘海 行程信息ServiceImpl
 */
@Service
public class RouteTripServiceImpl implements RouteTripService {

	@Autowired
	private SelfSupportRouteRepository selfSupportRouteRepository;
	
	@Autowired
	private RouteTripRepository  routeTripRepository;

	@Override
	public RouteTrip saveRouteTrip(RouteTrip routeTrip,  String routeId) {
		SelfSupportRoute selfSupportRoute = selfSupportRouteRepository.findOne(routeId);
		if(selfSupportRoute!=null){
			routeTrip.setSelfSupportRoute(selfSupportRoute);
			return routeTripRepository.save(routeTrip);
		}else{
			return null;
		}

	}

	@Override
	public Page<RouteTrip> findAll(Pageable pageable,String id) {
		return routeTripRepository.findBySelfSupportRouteId(pageable, id);
	}

	@Override
	public Long count() {
		return routeTripRepository.count();
	}
	
	@Override
	public void delete(String id) {
		routeTripRepository.delete(id);
	}

	@Override
	public RouteTrip save(RouteTrip routeTrip) {
		RouteTrip temp=routeTripRepository.findOne(routeTrip.getId());
		routeTrip.setSelfSupportRoute(temp.getSelfSupportRoute());
		routeTrip.setRouteDayList(temp.getRouteDayList());
		return routeTripRepository.save(routeTrip);
	}
}
