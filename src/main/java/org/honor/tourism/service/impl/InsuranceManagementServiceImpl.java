package org.honor.tourism.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.honor.tourism.entity.InsuranceManagement;
import org.honor.tourism.entity.InsuranceType;
import org.honor.tourism.repository.InsuranceManagementRepository;
import org.honor.tourism.repository.InsuranceTypeRepository;
import org.honor.tourism.service.InsuranceManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 保险管理ServiceImpl
 * @author Administrator
 *
 */
@Service
public class InsuranceManagementServiceImpl implements InsuranceManagementService {
	
	@Autowired
	private InsuranceManagementRepository repository;
	
	@Autowired
	private InsuranceTypeRepository repository2;

	@Override
	public Page<InsuranceManagement> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public InsuranceManagement save(InsuranceManagement insuranceManagement) {
		return repository.save(insuranceManagement);
	}

	@Override
	public void delete(String id) {
		repository.delete(id);
	}
	
	@Override
	public List<InsuranceManagement> findOne(String id) {
		List<InsuranceManagement> rows = new ArrayList<InsuranceManagement>();
		rows.add(repository.findOne(id));
		return rows;
	}

	@Override
	public Page<InsuranceManagement> findByInsuranceNameLike(String insuranceName, Pageable pageable) {
		return repository.findByInsuranceNameLike(insuranceName, pageable);
	}

	
}
