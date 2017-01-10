package org.honor.tourism.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.honor.tourism.entity.PriceInventory;
import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.repository.PriceInventoryRepository;
import org.honor.tourism.repository.SelfSupportRouteRepository;
import org.honor.tourism.service.SelfSupportRouteService;
import org.honor.tourism.util.EasyuiPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
/**
 * 作者:修罗大人
 * 日期:Jan 4, 2017
 * 时间:10:29:36 AM
 * 自营线路ServiceImpl
 */
public class SelfSupportRouteServiceImpl extends CrudServiceImpl<SelfSupportRoute> implements SelfSupportRouteService {
	
	@Autowired
	private SelfSupportRouteRepository selfSupportRouteRepository;
	
	//库存Repository
	@Autowired
	private PriceInventoryRepository priceInventoryRepository;
	
	@Autowired
	public SelfSupportRouteServiceImpl(JpaRepository<SelfSupportRoute, String> repository) {
		super(repository);
	}

	@Override
	public SelfSupportRoute findRouteWithId(String routeId)
	{
		SelfSupportRoute selfSupportRoute = selfSupportRouteRepository.findOne(routeId);
		return selfSupportRoute;
	}
	
	@Override
	public Page<SelfSupportRoute> findByRouteBaseInfoRouteNameOrRouteBaseInfoOutPlaceOrRouteBaseInfoDestinationOrRouteBaseInfoRouteTypeListTypeName(
			String routeName, String outPlace, String destination, String typeName, Integer startDays, Integer endDays, Pageable pageable) {
		return selfSupportRouteRepository.findByRouteBaseInfoRouteNameOrRouteBaseInfoOutPlaceOrRouteBaseInfoDestinationOrRouteBaseInfoRouteTypeListTypeName(routeName, outPlace, destination, typeName, startDays, endDays, pageable);
	}

	/**
	 * 查询线路的全部库存(带分页)
	 * @param routeId
	 * @param page
	 * @return
	 */
	@Override
	public List<PriceInventory> findPriceInventorysWithRouteId(EasyuiPage page,String routeId)
	{
		SelfSupportRoute selfSupportRoute = selfSupportRouteRepository.findOne(routeId);
		List<PriceInventory> priceInventorie = selfSupportRoute.getPriceInventory();
		
		//分页
		Integer startIndex = page.getPage() * page.getRows();
		Integer endIndex = (page.getPage() + 1) * page.getRows();
		
		endIndex = endIndex > 0 ? endIndex - 1 : 0;
		
		List<PriceInventory> rows = new ArrayList<PriceInventory>();
		
		for (int i = 0;i < priceInventorie.size();i++) {
			if (i >= startIndex && i <= endIndex) {
				rows.add(priceInventorie.get(i));
			}
		}
		
		return rows;
	}
	
	/**
	 * 获取线路的库存数
	 * @param routeId
	 * @return
	 */
	public Integer priceInventorieCount(String routeId)
	{
		SelfSupportRoute selfSupportRoute = selfSupportRouteRepository.findOne(routeId);
		List<PriceInventory> priceInventorie = selfSupportRoute.getPriceInventory();
		
		return priceInventorie.size();
	}
}
