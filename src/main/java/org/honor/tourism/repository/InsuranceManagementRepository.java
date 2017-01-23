package org.honor.tourism.repository;

import org.honor.tourism.entity.InsuranceManagement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 保险管理Repository
 *
 */
public interface InsuranceManagementRepository extends JpaRepository<InsuranceManagement, String> {
	
	public Page<InsuranceManagement> findByInsuranceNameLike(String insuranceName, Pageable pageable);
}
