package org.honor.tourism.service.impl;

import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.HotelCategories;
import org.honor.tourism.entity.HotelLevel;
import org.honor.tourism.entity.HotelProvideService;
import org.honor.tourism.repository.HotelCategoriesRepository;
import org.honor.tourism.repository.HotelLevelRepository;
import org.honor.tourism.repository.HotelProvideServiceRepository;
import org.honor.tourism.service.HotelCategoriesService;
import org.honor.tourism.service.HotelLevelService;
import org.honor.tourism.service.HotelProvideServiceService;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * 酒店星级
 */
@Service
public class HotelProvideServiceServiceImpl extends CrudServiceImpl<HotelProvideService> implements HotelProvideServiceService {

	@Autowired
	private HotelProvideServiceRepository hotelProvideServiceRepository;
	
	@Autowired
	public HotelProvideServiceServiceImpl(JpaRepository<HotelProvideService, String> repository) {
		super(repository);
	}
	
	public Map<String, Object> delete(List<HotelProvideService> hotelProvideService) {
		hotelProvideServiceRepository.delete(hotelProvideService);
		return EasyuiResult.result(true);
	}

	@Override
	public List<HotelProvideService> findAll() {
		return hotelProvideServiceRepository.findAll();
	}
}
