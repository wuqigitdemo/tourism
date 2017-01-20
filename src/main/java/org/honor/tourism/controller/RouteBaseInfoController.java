package org.honor.tourism.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.honor.tourism.entity.InsuranceType;
import org.honor.tourism.entity.RouteBaseInfo;
import org.honor.tourism.entity.RouteType;
import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.entity.TourismTheme;
import org.honor.tourism.entity.Traffic;
import org.honor.tourism.entity.VisaNationals;
import org.honor.tourism.repository.SelfSupportRouteRepository;
import org.honor.tourism.service.RouteBaseInfoService;
import org.honor.tourism.service.RouteTypeService;
import org.honor.tourism.service.SelfSupportRouteService;
import org.honor.tourism.service.TourismThemeService;
import org.honor.tourism.service.TrafficWayService;
import org.honor.tourism.service.VisaNationalsService;
import org.honor.tourism.util.EasyuiPage;
import org.honor.tourism.util.EasyuiResult;
import org.honor.tourism.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
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
 * 自营线路信息Controller
 *
 */
@Controller
@RequestMapping("/RouteBaseInfo")
public class RouteBaseInfoController {
	
	@Autowired 
	private RouteBaseInfoService service;
	
	@Autowired 
	private TrafficWayService trafficWayService;
	
	@Autowired 
	private VisaNationalsService visaNationalsService;
	
	@Autowired 
	private RouteTypeService routeTypeService;
	
	@Autowired 
	private TourismThemeService tourismThemeService;
	
	@Autowired 
	private FileUpload fileUpload;
	
	@Autowired 
	private SelfSupportRouteService selfSupportRouteService;
	
	@Autowired
	private SelfSupportRouteRepository selfSupportRouteRepository;
	
	/**
	 * 获取自营线路信息
	 * @param page
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<RouteBaseInfo> pageRouteBaseInfo =  service.findAll(pageable);
		List<RouteBaseInfo> rows = pageRouteBaseInfo.getContent();
		Long total = service.count();
		return EasyuiResult.result(rows, total);
	}
	
	/**
	 * 保存成功后跳转到行程信息
	 * @param model
	 * @param routeId
	 * @return
	 */
	@RequestMapping(value = "/travelInformationAddHtml",method = RequestMethod.GET)
	public String travelInformationAddHtml (ModelMap model, String routeId) {
		
		SelfSupportRoute selfSupportRoute = selfSupportRouteService.findRouteWithId(routeId);
		
		model.addAttribute("selfSupportRoute", selfSupportRoute);
		return "/ProductBusinessManage/RouteManage/RouteTrip";
	}
	
	/**
	 * 修改基本信息
	 * @param model
	 * @param routeId
	 * @return
	 */
	@RequestMapping(value = "/basicInformationUpdateHtml",method = RequestMethod.GET)
	public String basicInformationUpdateHtml (ModelMap model, String routeId) {
		
		SelfSupportRoute selfSupportRoute = selfSupportRouteService.findRouteWithId(routeId);
		
		model.addAttribute("selfSupportRoute", selfSupportRoute);
		return "/ProductBusinessManage/RouteManage/RouteBaseInfoUpdate";
	}
	
	/**
	 * 查看基本信息
	 * @param model
	 * @param routeId
	 * @return
	 */
	@RequestMapping(value = "/basicInformationViewHtml",method = RequestMethod.GET)
	public String basicInformationViewHtml (ModelMap model, String routeId) {
		
		SelfSupportRoute selfSupportRoute = selfSupportRouteService.findRouteWithId(routeId);
		
		model.addAttribute("selfSupportRoute", selfSupportRoute);
		return "/ProductBusinessManage/RouteManage/RouteBaseInfoView";
	}
	
	
	
	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(@Valid @RequestBody RouteBaseInfo routeBaseInfo, BindingResult result) {
		if (result.hasErrors()) {//数据交验
			return EasyuiResult.result(result);
		}
		RouteBaseInfo returnRouteBaseInfo = service.update(routeBaseInfo);
		if (returnRouteBaseInfo == null) {
			EasyuiResult.result(false, "保存失败");
		}
		return EasyuiResult.result(true);
	}
	
	/**
	 * 新增和修改自营线路信息
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(@Valid @RequestBody RouteBaseInfo routeBaseInfo, BindingResult result) {
		if (result.hasErrors()) {//数据交验
			return EasyuiResult.result(result);
        }
		//RouteBaseInfo returnRouteBaseInfo = service.save(routeBaseInfo);
		System.out.println("11====="+routeBaseInfo.getListRouteDiagram());
		SelfSupportRoute returnSelfSupportRoute = service.save(routeBaseInfo);
		if (returnSelfSupportRoute == null) {
			EasyuiResult.result(false, "添加失败");
		}
		return EasyuiResult.result(true,returnSelfSupportRoute.getId().toString());
	}
	
	/**
	 * 删除自营线路信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(String id) {
		service.delete(id);
		return EasyuiResult.result(true);
	}
	
	/**
	 * 查询交通方式
	 * @param page
	 * @return
	 */
	@RequestMapping("/selectGoWay")
	@ResponseBody
	public List<Traffic> selectType() {
		Pageable pageable = new PageRequest(0, 100000);
		Page<Traffic> traffic =  trafficWayService.findAll(pageable);
		List<Traffic> rows = traffic.getContent();
		return rows;
	}

	/**
	 * 查询签证国家
	 * @param page
	 * @return
	 */
	@RequestMapping("/selectCountry")
	@ResponseBody
	public List<VisaNationals> selectCountry() {
		Pageable pageable = new PageRequest(0, 100000);
		Page<VisaNationals> visaNationals =  visaNationalsService.findAll(pageable);
		List<VisaNationals> rows = visaNationals.getContent();
		return rows;
	}
	/**
	 * 查询线路类别list
	 * @param page
	 * @return
	 */
	@RequestMapping("/selectRouteTypeList")
	@ResponseBody
	public List<RouteType> selectRouteTypeList() {
		List<RouteType> routeTypeList =  routeTypeService.findAll();
		return routeTypeList;
	}
	
	/**
	 * 查询旅游主题
	 * @param page
	 * @return
	 */
	@RequestMapping("/selectTourismTheme")
	@ResponseBody
	public List<TourismTheme> selecttourismTheme() {
		Pageable pageable = new PageRequest(0, 100000);
		Page<TourismTheme> tourismTheme = tourismThemeService.findAll(pageable);
		List<TourismTheme> rows = tourismTheme.getContent();
		return rows;
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
	
	/**
	 * 根据id查询基础信息
	 * @param page
	 * @return
	 */
	@RequestMapping("/findOne")
	@ResponseBody
	public RouteBaseInfo findOne(String id){
		RouteBaseInfo routeBaseInfo =  service.findOne(id);
		return routeBaseInfo;
	}
	
}
