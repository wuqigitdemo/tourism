package org.honor.tourism.repository;

import org.honor.tourism.entity.HotelManagement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelManagementRepository extends JpaRepository<HotelManagement, String> {

	//查询方法
	public Page<HotelManagement> findSearch(String hotelName,String phone,String levelName, String cityName,Pageable pageable);
	
}
