package org.honor.tourism.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.honor.tourism.entity.RouteDay;
import org.honor.tourism.entity.RouteTrip;
import org.honor.tourism.service.RouteTripService;
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
 * @author 刘海 行程信息controller
 */

@Controller
@RequestMapping("/RouteTrip")
public class RouteTripController {

	  @Autowired 
	  public RouteTripService routeTripService;
	  
	  @Autowired 
	  private FileUpload fileUpload;
	 
	/**
	 * 保存行程信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/saveRouteTrip", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveRouteTrip(@Valid @RequestBody RouteTrip routeTrip,@Valid @RequestBody RouteDay routeDay, BindingResult result,
			String routeId) {
		if (result.hasErrors()) {// 数据交验
			return EasyuiResult.result(result);
		}
		try {
			 routeTripService.saveRouteTrip(routeTrip,routeDay, routeId);
		} catch (Exception e) {
			return EasyuiResult.result(true, "操作失败");
		}

		return EasyuiResult.result(true, "操作成功");
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
