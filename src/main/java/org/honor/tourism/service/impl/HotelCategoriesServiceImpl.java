package org.honor.tourism.service.impl;

import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.HotelCategories;
import org.honor.tourism.repository.HotelCategoriesRepository;
import org.honor.tourism.service.HotelCategoriesService;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * 作者:修罗大人
 * 日期:Dec 21, 2016
 * 时间:10:50:08 AM
 */
@Service
public class HotelCategoriesServiceImpl extends CrudServiceImpl<HotelCategories> implements HotelCategoriesService {

	@Autowired
	private HotelCategoriesRepository hotelCategoriesRepository;
	
	@Autowired
	public HotelCategoriesServiceImpl(JpaRepository<HotelCategories, String> repository) {
		super(repository);
	}
	
	public Map<String, Object> delete(List<HotelCategories> hotelCategories) {
		hotelCategoriesRepository.delete(hotelCategories);
		return EasyuiResult.result(true);
	}
}
