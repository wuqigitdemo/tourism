package org.honor.tourism.controller;

import java.util.Map;

import javax.validation.Valid;

import org.honor.tourism.entity.SelfSupportRouteOtherInfo;
import org.honor.tourism.service.CrudService;
import org.honor.tourism.service.SelfSupportRouteOtherInfoService;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 作者:修罗大人
 * 日期:Dec 28, 2016
 * 时间:10:37:43 AM
 * 其他信息Controller
 */

@Controller
@RequestMapping("/SelfSupportRouteOtherInfo")
public class SelfSupportRouteOtherInfoController extends CrudController<SelfSupportRouteOtherInfo>{

	@Autowired
	public SelfSupportRouteOtherInfoService selfSupportRouteOtherInfoService;
	
	@Autowired
	public SelfSupportRouteOtherInfoController(CrudService<SelfSupportRouteOtherInfo> service) {
		super(service);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 保存其他信息
	 * @param selfSupportRouteOtherInfo
	 * @param result
	 * @param routeId
	 * @return
	 */
	@RequestMapping(value = "/saveOtherInfo",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveOtherInfo(@Valid SelfSupportRouteOtherInfo selfSupportRouteOtherInfo,BindingResult result, String routeId) {
		if (result.hasErrors()) {//数据交验
			return EasyuiResult.result(result);
        }
		
		try {
			selfSupportRouteOtherInfoService.saveOtherInfo(selfSupportRouteOtherInfo, routeId);
		} catch (Exception e) {
			e.printStackTrace();
			return EasyuiResult.result(false,"操作失败");
		}
		
		return EasyuiResult.result(true,"操作成功");
	}
}
