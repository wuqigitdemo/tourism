package org.honor.tourism.controller;

import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.HotelLevel;
import org.honor.tourism.service.CrudService;
import org.honor.tourism.service.HotelLevelService;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 酒店星级管理
 */

@Controller
@RequestMapping("/HotelLevel")
public class HotelLevelController extends CrudController<HotelLevel>{
	
	@Autowired
	private HotelLevelService hotelLevelService;
	
	@Autowired 
	public HotelLevelController(CrudService<HotelLevel> service) {
		super(service);
	}
	
	/**
	 * 获取酒店星级
	 * @param page
	 * @return
	 */
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<HotelLevel> selectAll() {
		List<HotelLevel> HotelLevel =  hotelLevelService.findAll();
		return HotelLevel;
	}
	
	@RequestMapping("/deleteList")
	@ResponseBody
	public Map<String, Object> deleteList(@RequestBody List<HotelLevel> HotelLevel) {
		hotelLevelService.delete(HotelLevel);
		return EasyuiResult.result(true);
	}
}
