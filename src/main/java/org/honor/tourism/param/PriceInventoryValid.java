package org.honor.tourism.param;

import java.util.List;

import javax.validation.Valid;

import org.honor.tourism.entity.PriceInventory;

/**
 * 作者:修罗大人
 * 日期:Jan 6, 2017
 * 时间:1:34:32 PM
 * 为了验证方便而包装的Bean，内容是库存
 */

public class PriceInventoryValid {

	//库存
	@Valid
	private List<PriceInventory> priceInventorys;

	public List<PriceInventory> getPriceInventorys()
	{
		return priceInventorys;
	}

	public void setPriceInventorys(List<PriceInventory> priceInventory)
	{
		this.priceInventorys = priceInventory;
	}
}
