package org.honor.tourism.service.impl;


import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.repository.SelfSupportRouteRepository;
import org.honor.tourism.service.SelfSupportRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
/**
 * 作者:修罗大人
 * 日期:Jan 4, 2017
 * 时间:10:29:36 AM
 * 自营线路ServiceImpl
 */
public class SelfSupportRouteServiceImpl extends CrudServiceImpl<SelfSupportRoute> implements SelfSupportRouteService {
	
	@Autowired
	private SelfSupportRouteRepository selfSupportRouteRepository;
	
	@Autowired
	public SelfSupportRouteServiceImpl(JpaRepository<SelfSupportRoute, String> repository) {
		super(repository);
	}

	@Override
	public SelfSupportRoute findRouteWithId(String routeId)
	{
		SelfSupportRoute selfSupportRoute = selfSupportRouteRepository.findOne(routeId);
		return selfSupportRoute;
	}
	@Override
	public Page<SelfSupportRoute> findByRouteBaseInfoRouteNameOrRouteBaseInfoOutPlaceOrRouteBaseInfoDestinationOrRouteBaseInfoRouteTypeListTypeName(
			String routeName, String outPlace, String destination, String typeName, Pageable pageable) {
		return selfSupportRouteRepository.findByRouteBaseInfoRouteNameOrRouteBaseInfoOutPlaceOrRouteBaseInfoDestinationOrRouteBaseInfoRouteTypeListTypeName(routeName, outPlace, destination, typeName, pageable);
	}

}
