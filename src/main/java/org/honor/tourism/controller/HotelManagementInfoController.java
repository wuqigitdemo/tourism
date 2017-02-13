package org.honor.tourism.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.honor.tourism.entity.HotelLevel;
import org.honor.tourism.entity.HotelManagement;
import org.honor.tourism.entity.RouteBaseInfo;
import org.honor.tourism.entity.RouteTrip;
import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.service.CrudService;
import org.honor.tourism.service.HotelManagementService;
import org.honor.tourism.util.EasyuiPage;
import org.honor.tourism.util.EasyuiResult;
import org.honor.tourism.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 酒店管理信息Controller
 *
 */
@Controller
@RequestMapping("/HotelManagementInfo")
public class HotelManagementInfoController extends CrudController<HotelManagement> {
	

	@Autowired 
	private HotelManagementService hotelManagementService;
	
	@Autowired 
	private FileUpload fileUpload;
	
	@Autowired
	public HotelManagementInfoController(CrudService<HotelManagement> service) {
		super(service);
	}
	/**
	 * 获取酒店信息
	 * @param page
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<HotelManagement> pageHotelManagement =  hotelManagementService.findAll(pageable);
		List<HotelManagement> rows = pageHotelManagement.getContent();
		Long total = hotelManagementService.count();
		return EasyuiResult.result(rows, total);
	}
	
	/**
	 * 添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/hotelManagementAddHtml",method = RequestMethod.GET)
	public String HotelManagementAddHtml (ModelMap model, String id) {
		
		HotelManagement hotelManagement = hotelManagementService.findId(id);
		
		model.addAttribute("hotelManagement", hotelManagement);
		return "/ProductBusinessManage/RouteManage/HotelManagementAdd";
	}
	
	/**
	 * 修改信息
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/hotelManagementUpdateHtml",method = RequestMethod.GET)
	public String HotelManagementUpdateHtml (ModelMap model, String id) {
		
		HotelManagement hotelManagement = hotelManagementService.findId(id);
		
		model.addAttribute("hotelManagement", hotelManagement);
		return "/ProductBusinessManage/RouteManage/HotelManagementUpdate";
	}
	
	/**
	 * 查看信息
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/hotelManagementViewHtml",method = RequestMethod.GET)
	public String HotelManagementViewHtml (ModelMap model, String id) {
		
		HotelManagement hotelManagement = hotelManagementService.findId(id);
		
		model.addAttribute("hotelManagement", hotelManagement);
		return "/ProductBusinessManage/RouteManage/HotelManagementView";
	}
	
	/**
	 * 新增和修改信息
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(@Valid @RequestBody HotelManagement hotelManagement, BindingResult result) {
		if (result.hasErrors()) {//数据交验
			return EasyuiResult.result(result);
        }
		HotelManagement returnHotelManagement = hotelManagementService.save(hotelManagement);
		if (returnHotelManagement == null) {
			EasyuiResult.result(false, "添加失败");
		}
		return EasyuiResult.result(true,returnHotelManagement.getId().toString());
	}
	
	/**
	 * 删除信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/deletes")
	@ResponseBody
	public Map<String, Object> delete(@RequestBody List<HotelManagement> ids) {
		hotelManagementService.delete(ids);
		return EasyuiResult.result(true);
	}
	
	/**
	 * 查询
	 * @param hotelName
	 * @param phone
	 * @param levelName
	 * @param cityName
	 * @param page
	 * @return
	 */
	@RequestMapping("/findBySearch")
	@ResponseBody
	public Map<String, Object> findBySearch(String hotelName,String phone,String levelName, String cityName,EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<HotelManagement> pageList = hotelManagementService.findSearch(hotelName, phone, levelName, cityName, pageable); 
		List<HotelManagement> rows = pageList.getContent();
		long total = pageList.getTotalElements();
		return EasyuiResult.result(rows, total);
	}

	/**
	 * 图片上传
	 * @param page
	 * @return
	 */
	@RequestMapping("/fileUpload")
	@ResponseBody
	public String fileUpload(@RequestParam("fileUpload") MultipartFile file) {
		String imageName = fileUpload.uploadFile(file);
		if (imageName!= null) {
			return imageName;
		}
		return "false";
	}
	
}
