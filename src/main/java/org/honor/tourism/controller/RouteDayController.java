package org.honor.tourism.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.honor.tourism.entity.RouteDay;
import org.honor.tourism.service.RouteDayService;
import org.honor.tourism.util.EasyuiResult;
import org.honor.tourism.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author 刘海 日程信息controller
 */

@Controller
@RequestMapping("/RouteDay")
public class RouteDayController {

	@Autowired
	private RouteDayService service;
	
	  @Autowired 
	  private FileUpload fileUpload;
	  
	  /**
		 * 根据行程id获取日程
		 * @param page
		 * @return
		 */
		@RequestMapping("/selectedAll")
		@ResponseBody
		public List<RouteDay> findAll(String routeTripId) {
			List<RouteDay>  routeDays=  service.selectedAll(routeTripId);
			return routeDays;
		}
	  
	  
	  
		/**
		 * 获取日程信息
		 * @param page
		 * @return
		 */
		@RequestMapping("/findAll")
		@ResponseBody
		public List<RouteDay> findAll() {
			List<RouteDay>  routeDays=  service.findAll();
			return routeDays;
		}
	 
	/**
	 * 新增和修改日程
	 * 
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveRouteDay(@Valid @RequestBody RouteDay routeDay, BindingResult result,
			String routeTripId) {
		if (result.hasErrors()) {// 数据交验
			return EasyuiResult.result(result);
		}
		RouteDay returnRouteDay=service.saveRouteDay(routeDay, routeTripId);
		if (returnRouteDay == null) {
			EasyuiResult.result(false, "添加失败");
		}
		return EasyuiResult.result(true);
	}
	
	
	/**
	 * 修改完成后保存日程
	 * 
	 * @return
	 */
	@RequestMapping("/saveRouteDay")
	@ResponseBody
	public Map<String, Object> save(@Valid @RequestBody RouteDay routeDay, BindingResult result) {
		if (result.hasErrors()) {//数据交验
			return EasyuiResult.result(result);
      }
		RouteDay returnRouteDay = service.save(routeDay);
		if (returnRouteDay == null) {
			EasyuiResult.result(false, "添加失败");
		}
		return EasyuiResult.result(true);
	}
	

	/**
	 * 删除行程
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(String id) {
		service.delete(id);
		return EasyuiResult.result(true);
	}
	
	
	@RequestMapping("/fileUpload")
	@ResponseBody
	public String fileUpload(@RequestParam("uploadFile") MultipartFile file){
		String fileName=fileUpload.uploadFile(file);
		if(fileName!=null){
			return fileName;
		}
		return "false";
	}
}
