package org.honor.tourism.service.impl;

import org.honor.tourism.entity.ScenicManagement;
import org.honor.tourism.repository.ScenicManagementRepository;
import org.honor.tourism.service.ScenicManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 刘海 景区管理信息ServiceImpl
 */
@Service
public class ScenicManagementServiceImpl implements ScenicManagementService {
	
	@Autowired
	private ScenicManagementRepository repository;

	@Override
	public Page<ScenicManagement> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public ScenicManagement save(ScenicManagement scenicManagement) {
		return repository.save(scenicManagement);
	}

	@Override
	public void delete(String id) {
		repository.delete(id);
	}

	@Override
	public Page<ScenicManagement> findByScenicNumberOrScenicName(String scenicName, Integer scenicNumber,
			Pageable pageable) {
		return repository.findByScenicNumberOrScenicName(scenicName, scenicNumber, pageable);
	}

	@Override
	public ScenicManagement findScenicById(String scenicId) {
		return repository.findOne(scenicId);
	}

	@Override
	public ScenicManagement modifyScenicById(String scenicId) {
		ScenicManagement scenicManagement = repository.findOne(scenicId);
		return scenicManagement;
	}

}
