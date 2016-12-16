package org.honor.tourism.service.impl;

import org.honor.tourism.entity.Traffic;
import org.honor.tourism.repository.TrafficWayRepository;
import org.honor.tourism.service.TrafficWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TrafficWayServiceImpl implements TrafficWayService {

	@Autowired
	private TrafficWayRepository repository;

	@Override
	public Page<Traffic> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public Traffic save(Traffic traffic) {
		return repository.save(traffic);
	}

	@Override
	public void delete(String id) {
		repository.delete(id);
	}
}
