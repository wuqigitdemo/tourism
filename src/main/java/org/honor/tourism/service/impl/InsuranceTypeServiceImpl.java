package org.honor.tourism.service.impl;

import org.honor.tourism.entity.InsuranceType;
import org.honor.tourism.repository.InsuranceTypeRepository;
import org.honor.tourism.service.InsuranceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InsuranceTypeServiceImpl implements InsuranceTypeService {
	
	@Autowired
	private InsuranceTypeRepository repository;

	@Override
	public Page<InsuranceType> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public InsuranceType save(InsuranceType insuranceType) {
		return repository.save(insuranceType);
	}

	@Override
	public void delete(String id) {
		repository.delete(id);
	}

}
