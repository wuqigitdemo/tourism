package org.honor.tourism.service.impl;

import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.HotelCategories;
import org.honor.tourism.entity.HotelLevel;
import org.honor.tourism.repository.HotelCategoriesRepository;
import org.honor.tourism.repository.HotelLevelRepository;
import org.honor.tourism.service.HotelCategoriesService;
import org.honor.tourism.service.HotelLevelService;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * 酒店星级
 */
@Service
public class HotelLevelServiceImpl extends CrudServiceImpl<HotelLevel> implements HotelLevelService {

	@Autowired
	private HotelLevelRepository hotelLevelRepository;
	
	@Autowired
	public HotelLevelServiceImpl(JpaRepository<HotelLevel, String> repository) {
		super(repository);
	}
	
	public Map<String, Object> delete(List<HotelLevel> hotelLevel) {
		hotelLevelRepository.delete(hotelLevel);
		return EasyuiResult.result(true);
	}

	@Override
	public List<HotelLevel> findAll() {
		return hotelLevelRepository.findAll();
	}
}
