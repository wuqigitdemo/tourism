package org.honor.tourism.service;

import java.util.List;

import org.honor.tourism.entity.InsuranceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 保险种类service
 * @author 刘海
 *
 */
public interface InsuranceTypeService {

	public Page<InsuranceType> findAll(Pageable pageable);

	public Long count();

	public InsuranceType save(InsuranceType insuranceType);

	public void delete(String id);
	
	public List<InsuranceType> findAll();


}
