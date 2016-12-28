package org.honor.tourism.service;

import org.honor.tourism.entity.RouteBaseInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 自营路线信息
 */
public interface RouteBaseInfoService {
	
	public Page<RouteBaseInfo> findAll(Pageable pageable);
	
	public Long count();
	
	public RouteBaseInfo save(RouteBaseInfo routeBaseInfo);
	
	public void delete(String id);

}
