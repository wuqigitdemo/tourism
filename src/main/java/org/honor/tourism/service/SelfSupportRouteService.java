package org.honor.tourism.service;

import java.util.List;

import org.honor.tourism.entity.PriceInventory;
import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.util.EasyuiPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 作者:修罗大人
 * 日期:Jan 4, 2017
 * 时间:10:29:36 AM
 * 自营线路Service
 */

public interface SelfSupportRouteService extends CrudService<SelfSupportRoute> {

	public SelfSupportRoute findRouteWithId (String routeId);
	
	/**
	 * 查询线路的全部库存(带分页)
	 * @param routeId
	 * @param page
	 * @return
	 */
	public List<PriceInventory> findPriceInventorysWithRouteId (EasyuiPage page,String routeId);
	
	/**
	 * 获取线路的库存数
	 * @param routeId
	 * @return
	 */
	public Integer priceInventorieCount(String routeId);
	
	public Page<SelfSupportRoute> findByRouteBaseInfoRouteNameOrRouteBaseInfoOutPlaceOrRouteBaseInfoDestinationOrRouteBaseInfoRouteTypeListTypeName(String routeName, String outPlace, String destination, String typeName, Integer startDays, Integer endDays, Pageable pageable);

	/**
	 * 删除多个自营线路
	 * @param ids
	 */
	public void delete(List<SelfSupportRoute> ids);
	
}
