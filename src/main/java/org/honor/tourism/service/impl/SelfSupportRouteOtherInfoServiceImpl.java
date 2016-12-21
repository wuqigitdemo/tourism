package org.honor.tourism.service.impl;

import org.honor.tourism.entity.SelfSupportRouteOtherInfo;
import org.honor.tourism.repository.SelfSupportRouteOtherInfoRepository;
import org.honor.tourism.service.SelfSupportRouteOtherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SelfSupportRouteOtherInfoServiceImpl implements SelfSupportRouteOtherInfoService {

	@Autowired
	private SelfSupportRouteOtherInfoRepository repository;
	
	@Override
	public Page<SelfSupportRouteOtherInfo> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public SelfSupportRouteOtherInfo save(SelfSupportRouteOtherInfo selfSupportRouteOtherInfo) {
		return repository.save(selfSupportRouteOtherInfo);
	}

	@Override
	public void delete(String id) {
		repository.delete(id);
	}

}
