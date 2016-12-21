package org.honor.tourism.service;

import org.honor.tourism.entity.VisaNationals;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *签证国家Service
 * @author 刘海
 *
 */
public interface VisaNationalsService {
	
	public Page<VisaNationals> findAll(Pageable pageable);
	
	public Long count();
	
	public VisaNationals save(VisaNationals visaNationals);
	
	public void delete(String id);

}
