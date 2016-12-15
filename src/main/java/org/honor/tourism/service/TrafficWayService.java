package org.honor.tourism.service;

import org.honor.tourism.entity.Traffic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 旅游方式Service
 * @author 刘海
 *
 */
public interface TrafficWayService {
	
	public Page<Traffic> findAll(Pageable pageable);
	
	public Long count();
	
	public Traffic save(Traffic traffic);
	
	public void delete(String id);
	
}
