package org.honor.tourism.service.impl;

import org.honor.tourism.entity.RouteBaseInfo;
import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.repository.RouteBaseInfoRepository;
import org.honor.tourism.service.RouteBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RouteBaseInfoServiceImpl implements RouteBaseInfoService {

	@Autowired
	private RouteBaseInfoRepository repository;
	
	@Override
	public Page<RouteBaseInfo> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public RouteBaseInfo save(RouteBaseInfo routeBaseInfo) {
		return repository.save(routeBaseInfo);
	}

	@Override
	public void delete(String id) {
		repository.delete(id);
	}

}
