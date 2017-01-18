package org.honor.tourism.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 封装的增册改查Service接口实现
 * @author keiwu
 *
 * @param <T>
 */
public class CrudServiceImpl<T> {
	
	private JpaRepository<T, String> repository;
	
	public CrudServiceImpl(JpaRepository<T, String> repository) {
		this.repository = repository;
	}
	
	public Page<T> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Long count() {
		return repository.count();
	}
	
	public T save(T t) {
		return repository.save(t);
	}

	public void delete(String id) {
		repository.delete(id);
	}
	
	public T findById(String id) {
		return repository.findOne(id);
	}

}
