package org.honor.tourism.service.impl;

import java.util.List;

import org.honor.tourism.entity.RouteType;
import org.honor.tourism.repository.RouteTypeRepository;
import org.honor.tourism.service.RouteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mysql.fabric.Response;

@Service
public class RouteTypeServiceImpl implements RouteTypeService {
	
	@Autowired
	private RouteTypeRepository repository;

	@Override
	public Page<RouteType> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public List<RouteType> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public RouteType save(RouteType tourismTheme) {
		return repository.save(tourismTheme);
	}

	@Override
	public void delete(String id) {
		repository.delete(id);
	}

	@Override
	public RouteType getOne(String id){
		return repository.getOne(id);
	}
}
