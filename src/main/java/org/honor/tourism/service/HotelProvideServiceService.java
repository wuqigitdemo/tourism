package org.honor.tourism.service;

import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.HotelProvideService;

/**
 * 酒店服务
 */

public interface HotelProvideServiceService extends CrudService<HotelProvideService> {

	public Map<String, Object> delete(List<HotelProvideService> hotelProvideService);
	
	public List<HotelProvideService> findAll();
}
