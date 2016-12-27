package org.honor.tourism.service.impl;

import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.repository.SelfSupportRouteBaseInfoRepository;
import org.honor.tourism.service.SelfSupportRouteBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SelfSupportRouteBaseInfoServiceImpl implements SelfSupportRouteBaseInfoService {

	@Autowired
	private SelfSupportRouteBaseInfoRepository repository;
	
	@Override
	public Page<SelfSupportRoute> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public SelfSupportRoute save(SelfSupportRoute selfSupportRoute) {
		return repository.save(selfSupportRoute);
	}

	@Override
	public void delete(String id) {
		repository.delete(id);
	}

}
