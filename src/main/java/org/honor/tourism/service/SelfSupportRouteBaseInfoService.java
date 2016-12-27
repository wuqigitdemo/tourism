package org.honor.tourism.service;

import org.honor.tourism.entity.SelfSupportRoute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 自营路线信息
 */
public interface SelfSupportRouteBaseInfoService {
	
	public Page<SelfSupportRoute> findAll(Pageable pageable);
	
	public Long count();
	
	public SelfSupportRoute save(SelfSupportRoute selfSupportRoute);
	
	public void delete(String id);

}
