package org.honor.tourism.service.impl;

import java.util.List;

import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.repository.SelfSupportRouteRepository;
import org.honor.tourism.service.SelfSupportRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SelfSupportRouteServiceImpl extends CrudServiceImpl<SelfSupportRoute> implements SelfSupportRouteService {
	
	@Autowired
	private SelfSupportRouteRepository repository;

	@Autowired
	public SelfSupportRouteServiceImpl(JpaRepository<SelfSupportRoute, String> repository) {
		super(repository);
	}

	@Override
	public List<SelfSupportRoute> findByRouteBaseInfoRouteNameOrRouteBaseInfoOutPlaceOrRouteBaseInfoDestinationOrRouteBaseInfoRouteTypeListTypeName(
			String routeName, String outPlace, String destination, String typeName, Pageable pageable) {
		return repository.findByRouteBaseInfoRouteNameOrRouteBaseInfoOutPlaceOrRouteBaseInfoDestinationOrRouteBaseInfoRouteTypeListTypeName(routeName, outPlace, destination, typeName, pageable);
	}

}
