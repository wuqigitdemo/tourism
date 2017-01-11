package org.honor.tourism.service;

import org.honor.tourism.entity.RouteBaseInfo;
import org.honor.tourism.entity.SelfSupportRoute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 自营路线信息
 */
public interface RouteBaseInfoService {
	
	public Page<RouteBaseInfo> findAll(Pageable pageable);
	
	public Long count();
	
	public SelfSupportRoute save(RouteBaseInfo routeBaseInfo);
	
	public RouteBaseInfo update(RouteBaseInfo routeBaseInfo);
	
	public void delete(String id);
	

}
