package org.honor.tourism.service;

import java.util.Map;

import org.honor.tourism.entity.PriceInventory;

/**
 * 作者:修罗大人
 * 日期:Dec 29, 2016
 * 时间:3:02:34 PM
 * 库存价格Service
 */

public interface PriceInventoryService extends CrudService<PriceInventory>{

	public Map<String, Object> savePriceInventory(PriceInventory priceInventory,String routeId);
}
