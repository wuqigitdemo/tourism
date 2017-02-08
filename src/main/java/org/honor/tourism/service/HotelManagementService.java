package org.honor.tourism.service;

import java.util.List;

import org.honor.tourism.entity.HotelManagement;
import org.honor.tourism.util.EasyuiPage;

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
	
}
