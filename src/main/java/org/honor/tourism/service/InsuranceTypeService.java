package org.honor.tourism.service;

import org.honor.tourism.entity.InsuranceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 旅游主题service
 * @author 刘海
 *
 */
public interface InsuranceTypeService {

	public Page<InsuranceType> findAll(Pageable pageable);

	public Long count();

	public InsuranceType save(InsuranceType insuranceType);

	public void delete(String id);

}
