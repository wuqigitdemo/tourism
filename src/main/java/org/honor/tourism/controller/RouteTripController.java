package org.honor.tourism.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.honor.tourism.entity.RouteTrip;
import org.honor.tourism.service.RouteTripService;
import org.honor.tourism.util.EasyuiPage;
import org.honor.tourism.util.EasyuiResult;
import org.honor.tourism.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	  public RouteTripService service;
	  
	  @Autowired 
	  private FileUpload fileUpload;
	  
		/**
		 * 获取行程信息
		 * @param page
		 * @return
		 */
		@RequestMapping("/findAll")
		@ResponseBody
		public Map<String, Object> findAll(EasyuiPage page) {
			Pageable pageable = new PageRequest(page.getPage(), page.getRows());
			Page<RouteTrip>  routeTrips=  service.findAll(pageable);
			List<RouteTrip> rows = routeTrips.getContent();
			Long total = service.count();
			return EasyuiResult.result(rows, total);
		}
	 
	/**
	 * 新增和修改行程
	 * 
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveRouteTrip(@Valid RouteTrip routeTrip, BindingResult result,
			String routeId) {
		if (result.hasErrors()) {// 数据交验
			return EasyuiResult.result(result);
		}
		RouteTrip returnRouteTrip=service.saveRouteTrip(routeTrip, routeId);
		if (returnRouteTrip == null) {
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
