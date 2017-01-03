package org.honor.tourism.controller;
import java.util.Map;
import javax.validation.Valid;

import org.honor.tourism.entity.PriceInventory;
import org.honor.tourism.service.CrudService;
import org.honor.tourism.service.PriceInventoryService;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 作者:修罗大人
 * 日期:Dec 28, 2016
 * 时间:10:37:43 AM
 * 价格库存Controller
 */

@Controller
@RequestMapping("/PriceInventory")
public class PriceInventoryController extends CrudController<PriceInventory>
{
	@Autowired
	public PriceInventoryService priceInventoryService;
	
	@Autowired 
	public PriceInventoryController(CrudService<PriceInventory> service) {
		super(service);
	}

	/**
	 * 保存库存
	 * @return
	 */
	@RequestMapping(value = "/savePriceInventory", method = RequestMethod.POST)  
	@ResponseBody
	public Map<String, Object> savePriceInventory(@Valid @RequestBody PriceInventory priceInventory,BindingResult result, String routeId) {
		if (result.hasErrors()) {//数据交验
			return EasyuiResult.result(result);
        }
		
		try {
			priceInventoryService.savePriceInventory(priceInventory,routeId);
		} catch (Exception e) {
			return EasyuiResult.result(true, "操作失败");
		}
		
		return EasyuiResult.result(true, "操作成功");
	}
}
