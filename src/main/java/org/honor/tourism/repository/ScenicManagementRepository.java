package org.honor.tourism.repository;

import org.honor.tourism.entity.ScenicManagement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScenicManagementRepository extends JpaRepository<ScenicManagement, String>{
	
	public Page<ScenicManagement> findByScenicNumberOrScenicName(String scenicName,Integer scenicNumber, Pageable pageable);

}
