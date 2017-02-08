package org.honor.tourism.controller;

import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.HotelProvideService;
import org.honor.tourism.service.CrudService;
import org.honor.tourism.service.HotelProvideServiceService;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 酒店服务管理
 */

@Controller
@RequestMapping("/HotelProvideService")
public class HotelProvideServiceController extends CrudController<HotelProvideService>{
	
	@Autowired
	private HotelProvideServiceService hotelProvideServiceService;
	
	@Autowired 
	public HotelProvideServiceController(CrudService<HotelProvideService> hotelProvideService) {
		super(hotelProvideService);
	}
	
	/**
	 * 获取酒店服务
	 * @param page
	 * @return
	 */
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<HotelProvideService> selectAll() {
		List<HotelProvideService> HotelProvideService =  hotelProvideServiceService.findAll();
		return HotelProvideService;
	}
	
	@RequestMapping("/deleteList")
	@ResponseBody
	public Map<String, Object> deleteList(@RequestBody List<HotelProvideService> hotelProvideService) {
		hotelProvideServiceService.delete(hotelProvideService);
		return EasyuiResult.result(true);
	}
}
