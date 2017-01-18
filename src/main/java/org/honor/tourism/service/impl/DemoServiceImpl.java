package org.honor.tourism.service.impl;

import org.honor.tourism.entity.Demo;
import org.honor.tourism.repository.DemoRepository;
import org.honor.tourism.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl extends CrudServiceImpl<Demo> implements DemoService {
	
	@Autowired
	private DemoRepository repository;

	@Autowired
	public DemoServiceImpl(JpaRepository<Demo, String> repository) {
		super(repository);
	}

}
