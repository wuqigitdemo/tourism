package org.honor.tourism.service.impl;

import javax.transaction.Transactional;

import org.honor.tourism.entity.DemoChildren;
import org.honor.tourism.repository.DemoChildrenRepository;
import org.honor.tourism.service.DemoChildrenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DemoChildrenServiceImpl extends CrudServiceImpl<DemoChildren> implements DemoChildrenService {
	
	@Autowired
	private DemoChildrenRepository repository;

	@Autowired
	public DemoChildrenServiceImpl(JpaRepository<DemoChildren, String> repository) {
		super(repository);
	}
	
	@Transactional
	public void deleteQuery(String id) {
		repository.deleteQuery(id);
	}

}
