package org.honor.tourism.service;

import java.util.List;

import org.honor.tourism.entity.RouteCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 线路类别Service
 *
 */
public interface RouteCategoryService {

	public Page<RouteCategory> findAll(Pageable pageable);
	
	public Long count();
	
	public RouteCategory save(RouteCategory routeCategory);
	
	public void delete(String id);
	
	public List<RouteCategory> findAll();
	
}
