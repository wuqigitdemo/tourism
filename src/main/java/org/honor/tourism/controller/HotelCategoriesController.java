package org.honor.tourism.controller;

import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.HotelCategories;
import org.honor.tourism.service.CrudService;
import org.honor.tourism.service.HotelCategoriesService;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 作者:修罗大人
 * 日期:Dec 21, 2016
 * 时间:10:25:07 AM
 * 酒店类型管理
 */

@Controller
@RequestMapping("/HotelCategories")
public class HotelCategoriesController extends CrudController<HotelCategories>{
	
	@Autowired
	private HotelCategoriesService hoteCategoriesService;
	
	@Autowired 
	public HotelCategoriesController(CrudService<HotelCategories> service) {
		super(service);
	}
	
	@RequestMapping("/deleteList")
	@ResponseBody
	public Map<String, Object> deleteList(@RequestBody List<HotelCategories> hotelCategories) {
		hoteCategoriesService.delete(hotelCategories);
		return EasyuiResult.result(true);
	}
}
