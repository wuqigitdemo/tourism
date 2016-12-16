package org.honor.tourism.service.impl;

import org.honor.tourism.entity.RouteCategory;
import org.honor.tourism.repository.RouteCategoryRepository;
import org.honor.tourism.service.RouteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 线路类别ServiceImpl
 * @author Administrator
 *
 */
@Service
public class RouteCategoryServiceImpl implements RouteCategoryService {
	
	@Autowired
	private RouteCategoryRepository repository;

	@Override
	public Page<RouteCategory> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public RouteCategory save(RouteCategory routeCategory) {
		return repository.save(routeCategory);
	}

	@Override
	public void delete(String id) {
		repository.delete(id);
	}

}
