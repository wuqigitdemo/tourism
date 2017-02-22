package org.honor.tourism.controller;

import org.honor.tourism.service.MyInvocationSecurityMetadataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 作者:修罗大人
 * 日期:Feb 22, 2017
 * 时间:2:08:12 PM
 * homeController为了动态刷新权限而存在
 */
@Controller
public class HomeController {

	@Autowired
	MyInvocationSecurityMetadataSourceService invocation;
	
	/**
	 * home
	 * @return
	 * 动态刷新权限
	 */
	@RequestMapping("/")
	public String home() {
		
		if (invocation != null) {
			invocation.loadResourceDefine();
		}
		
		return "home";
	}
}
