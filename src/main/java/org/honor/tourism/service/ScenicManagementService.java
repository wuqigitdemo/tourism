package org.honor.tourism.service;

import org.honor.tourism.entity.ScenicManagement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * 景区管理Service
 * @author 刘海
 *
 */
public interface ScenicManagementService {
	
	public Page<ScenicManagement> findAll(Pageable pageable);
	
	public Long count();
	
	public ScenicManagement save(ScenicManagement scenicManagement);
	
	public void delete(String id);

	public Page<ScenicManagement> findByScenicNumberOrScenicName(String scenicName, Integer scenicNumber,
			Pageable pageable);

	public ScenicManagement findScenicById(String scenicId);

	public ScenicManagement modifyScenicById(String scenicId);

}
