package org.honor.tourism.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.honor.tourism.entity.HotelManagement;
import org.honor.tourism.entity.PriceInventory;
import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.repository.HotelManagementRepository;
import org.honor.tourism.repository.PriceInventoryRepository;
import org.honor.tourism.repository.SelfSupportRouteRepository;
import org.honor.tourism.service.HotelManagementService;
import org.honor.tourism.service.SelfSupportRouteService;
import org.honor.tourism.util.EasyuiPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 酒店管理
 * 
 */
@Service
public class HotelManagementServiceImpl extends CrudServiceImpl<HotelManagement> implements HotelManagementService {
	
	@Autowired
	private HotelManagementRepository hotelManagementRepository;
	
	
	@Autowired
	public HotelManagementServiceImpl(JpaRepository<HotelManagement, String> repository) {
		super(repository);
	}

	@Override
	public HotelManagement findId(String id)
	{
		HotelManagement hotelManagement = hotelManagementRepository.findOne(id);
		return hotelManagement;
	}

	@Override
	public void delete(List<HotelManagement> ids) {
		hotelManagementRepository.delete(ids);
	}

	@Override
	public Page<HotelManagement> findSearch(String hotelName, String phone, String levelName, String cityName,Pageable pageable) {
		return hotelManagementRepository.findSearch(hotelName, phone, levelName, cityName,pageable);
	}
	
}
