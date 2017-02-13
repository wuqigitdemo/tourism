package org.honor.tourism.service;

import java.util.List;

import org.honor.tourism.entity.HotelManagement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 酒店管理
 * 
 */

public interface HotelManagementService extends CrudService<HotelManagement> {

	public HotelManagement findId (String id);

	/**
	 * 删除多个酒店信息
	 * @param ids
	 */
	public void delete(List<HotelManagement> ids);
	
	/**
	 * 查询方法
	 * @param hotelName
	 * @param phone
	 * @param levelName
	 * @param cityName
	 * @return
	 */
	public Page<HotelManagement> findSearch(String hotelName,String phone,String levelName, String cityName,Pageable pageable);
	
}
