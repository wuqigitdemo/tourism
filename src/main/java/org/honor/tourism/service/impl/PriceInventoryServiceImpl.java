package org.honor.tourism.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.honor.tourism.entity.PriceInventory;
import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.repository.PriceInventoryRepository;
import org.honor.tourism.repository.SelfSupportRouteRepository;
import org.honor.tourism.service.PriceInventoryService;
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
	private SelfSupportRouteRepository selfSupportRouteRepository;
	
	@Autowired
	private PriceInventoryRepository priceInventoryRepository;
	
	@Autowired
	public PriceInventoryServiceImpl(JpaRepository<PriceInventory, String> repository) {
		super(repository);
	}

	/**
	 * 保存库存
	 * @param priceInventorys
	 * @param routeId
	 * @return
	 */
	@Transactional
	public SelfSupportRoute savePriceInventory(List<PriceInventory> priceInventorys,String routeId)
	{
		//将库存保存到线路
		SelfSupportRoute selfSupportRoute = selfSupportRouteRepository.getOne(routeId);
		selfSupportRoute.setPriceInventory(priceInventorys);
		selfSupportRouteRepository.save(selfSupportRoute);
		
		return selfSupportRoute;
	}

	/**
	 * 查询单条库存详情
	 * @param priceInventoryId
	 * @return
	 */
	@Override
	public PriceInventory findOne(String priceInventoryId)
	{
		return priceInventoryRepository.findOne(priceInventoryId);
	}

	/**
	 * 删除库存
	 * @param priceInventorys
	 * @param routeId
	 */
	@Override
	public void deletePriceInventorys(List<PriceInventory> priceInventorys, String routeId)
	{
		SelfSupportRoute selfSupportRoute = selfSupportRouteRepository.getOne(routeId);
		
		List<PriceInventory> priceInventoriesTemp = selfSupportRoute.getPriceInventory();
		
		for (int i = 0; i < priceInventoriesTemp.size(); i++) 
		{
			PriceInventory priceInventoryTemp = priceInventoriesTemp.get(i);
			for (int j = 0; j < priceInventorys.size(); j++) 
			{
				PriceInventory priceInventory = priceInventorys.get(j);
				if (priceInventoryTemp.getId().equals(priceInventory.getId())) {
					//将库存从线路库存数组中移除
					priceInventoriesTemp.remove(priceInventoryTemp);
					priceInventoryRepository.delete(priceInventoryTemp);
					i--;
					break;
				}
			}
		}
		
		//将删除后的数组保存
		selfSupportRouteRepository.save(selfSupportRoute);
	}
}
