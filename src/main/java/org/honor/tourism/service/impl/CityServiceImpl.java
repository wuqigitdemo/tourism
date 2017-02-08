package org.honor.tourism.service.impl;

import java.util.List;

import org.honor.tourism.entity.City;
import org.honor.tourism.repository.CityRepository;
import org.honor.tourism.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityRepository repository;

	@Override
	public Page<City> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public City save(City city) {
		return repository.save(city);
	}

	@Override
	public void delete(String id) {
		repository.delete(id);
	}

	@Override
	public List<City> findAll() {
		return repository.findAll();
	}

}
