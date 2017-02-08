package org.honor.tourism.repository;

import org.honor.tourism.entity.HotelManagement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelManagementRepository extends JpaRepository<HotelManagement, String> {
	
}
