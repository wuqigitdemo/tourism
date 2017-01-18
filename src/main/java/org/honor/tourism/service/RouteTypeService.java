package org.honor.tourism.service;

import java.util.List;

import org.honor.tourism.entity.RouteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 旅游主题Service
 * @author keiwu
 *
 */
public interface RouteTypeService {

	public Page<RouteType> findAll(Pageable pageable);
	
	public Long count();
	
	public RouteType save(RouteType tourismTheme);
	
	public void delete(String id);

	public List<RouteType> findAll();
	
	public RouteType getOne(String id);
	
	public List<RouteType> findByRouteCategoryId(String routeCategoryId);
}
