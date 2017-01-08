package org.honor.tourism.controller;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.honor.tourism.entity.PriceInventory;
import org.honor.tourism.param.PriceInventoryValid;
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

import com.fasterxml.jackson.databind.util.ObjectBuffer;

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
	public Map<String, Object> savePriceInventory(@Valid @RequestBody PriceInventoryValid priceInventoryValid,BindingResult result, String routeId) {
		if (result.hasErrors()) {//数据交验
			return EasyuiResult.result(result);
        }
		
		try {
			priceInventoryService.savePriceInventory(priceInventoryValid.getPriceInventorys(),routeId);
		} catch (Exception e) {
			return EasyuiResult.result(true, "操作失败");
		}
		
		return EasyuiResult.result(true, "操作成功");
	}
	
	/**
	 * 查询单条库存详情
	 * @param priceInventoryId
	 * @return
	 */
	@RequestMapping(value = "/findOnePriceInventory",method = RequestMethod.POST)
	@ResponseBody
	public PriceInventory findOnePriceInventory (String priceInventoryId) {
		PriceInventory priceInventory = priceInventoryService.findOne(priceInventoryId);
		
		return priceInventory;
	}
	
	/**
	 * 价格库存修改
	 * @param priceInventory
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "priceInventoryUpdate",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> priceInventoryUpdate(@Valid @RequestBody PriceInventory priceInventory,BindingResult result) {
		if (result.hasErrors()) {
			return EasyuiResult.result(result);
		}
		
		try {
			//修改价格库存
			priceInventoryService.save(priceInventory);
		} catch (Exception e) {
			System.out.println("修改价格库存:");
			e.printStackTrace();
			return EasyuiResult.result(false,"操作失败");
		}
		
		return EasyuiResult.result(true,"操作成功");
	}
	
	/**
	 * 价格库存删除
	 * @param priceInventorys
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "priceInventoryDelete",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> priceInventoryDelete(@RequestBody List<PriceInventory> priceInventorys,String routeId) {
		
		try {
			//删除价格库存
			priceInventoryService.deletePriceInventorys(priceInventorys, routeId);
		} catch (Exception e) {
			System.out.println("修改价格库存:");
			e.printStackTrace();
			return EasyuiResult.result(false,"操作失败");
		}
		
		return EasyuiResult.result(true,"操作成功");
	}
}
