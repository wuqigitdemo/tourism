package org.honor.tourism.service.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.honor.tourism.entity.InventoryDate;
import org.honor.tourism.entity.PriceInventory;
import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.repository.InventoryDateRepository;
import org.honor.tourism.repository.SelfSupportRouteRepository;
import org.honor.tourism.service.PriceInventoryService;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * 作者:修罗大人
 * 日期:Dec 29, 2016
 * 时间:3:06:43 PM
 * 库存价格ServiceImpl
 */
@Service
public class PriceInventoryServiceImpl extends CrudServiceImpl<PriceInventory> implements PriceInventoryService{

	@Autowired
	private InventoryDateRepository inventoryDateRepository;
	
	@Autowired
	private SelfSupportRouteRepository selfSupportRouteRepository;
	
	@Autowired
	public PriceInventoryServiceImpl(JpaRepository<PriceInventory, String> repository) {
		super(repository);
	}

	@Transactional
	public Map<String, Object> savePriceInventory(PriceInventory priceInventory,String routeId)
	{
		List<InventoryDate> inventoryDates = priceInventory.getInventoryDateList();
		
		//保存日期
		for (InventoryDate inventoryDate : inventoryDates) {
			inventoryDateRepository.save(inventoryDate);
		}

		//保存库存
		super.save(priceInventory);
		
		//将库存保存到线路
		SelfSupportRoute selfSupportRoute = selfSupportRouteRepository.getOne(routeId);
		selfSupportRoute.setPriceInventory(priceInventory);
		selfSupportRouteRepository.save(selfSupportRoute);
		
		return EasyuiResult.result(true, "操作成功");
	}
}
