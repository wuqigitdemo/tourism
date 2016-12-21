package org.honor.tourism.service;

import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.HotelCategories;

/**
 * 作者:修罗大人
 * 日期:Dec 21, 2016
 * 时间:10:48:42 AM
 */

public interface HotelCategoriesService extends CrudService<HotelCategories> {

	public Map<String, Object> delete(List<HotelCategories> hotelCategories);
}
