package org.honor.tourism.service.impl;

import java.util.List;

import org.honor.tourism.entity.DiningType;
import org.honor.tourism.repository.DiningTypeRepository;
import org.honor.tourism.service.DiningTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DiningTypeServiceImpl extends CrudServiceImpl<DiningType> implements DiningTypeService {
	
	@Autowired
	private DiningTypeRepository repository;

	@Autowired
	public DiningTypeServiceImpl(JpaRepository<DiningType, String> repository) {
		super(repository);
	}
	
	@Override
	public List<DiningType> findAll() {
		return repository.findAll();
	}

}
