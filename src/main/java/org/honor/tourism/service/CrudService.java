package org.honor.tourism.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 封装的增册改查Service接口
 * @author keiwu
 *
 * @param <T>
 */
public interface CrudService<T> {

	public Page<T> findAll(Pageable pageable);
	
	public Long count();
	
	public T save(T t);
	
	public void delete(String id);
	
	public T findById(String id);
	
}
