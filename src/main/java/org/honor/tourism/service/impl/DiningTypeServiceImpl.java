package org.honor.tourism.service.impl;

import org.honor.tourism.entity.DiningType;
import org.honor.tourism.service.DiningTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DiningTypeServiceImpl extends CrudServiceImpl<DiningType> implements DiningTypeService {

	@Autowired
	public DiningTypeServiceImpl(JpaRepository<DiningType, String> repository) {
		super(repository);
	}

}
