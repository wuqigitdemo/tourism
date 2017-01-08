package org.honor.tourism.service;

import java.util.List;
import org.honor.tourism.entity.PriceInventory;
import org.honor.tourism.entity.SelfSupportRoute;

/**
 * 作者:修罗大人
 * 日期:Dec 29, 2016
 * 时间:3:02:34 PM
 * 库存价格Service
 */

public interface PriceInventoryService extends CrudService<PriceInventory>{

	/**
	 * 保存库存
	 * @param priceInventorys
	 * @param routeId
	 * @return
	 */
	public SelfSupportRoute savePriceInventory(List<PriceInventory> priceInventorys,String routeId);
	
	/**
	 * 查询单条库存详情
	 * @param priceInventoryId
	 * @return
	 */
	public PriceInventory findOne(String priceInventoryId);
	
	/**
	 * 删除库存
	 * @param priceInventorys
	 * @param routeId
	 */
	public void deletePriceInventorys(List<PriceInventory> priceInventorys,String routeId);
}
