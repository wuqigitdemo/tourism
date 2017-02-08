package org.honor.tourism.service;

import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.HotelLevel;

/**
 * 酒店星级
 */

public interface HotelLevelService extends CrudService<HotelLevel> {

	public Map<String, Object> delete(List<HotelLevel> hotelLevel);
	
	public List<HotelLevel> findAll();
}
