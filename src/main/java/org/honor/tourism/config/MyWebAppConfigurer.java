package org.honor.tourism.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/register").setViewName("register");
		registry.addViewController("/welcome").setViewName("welcome");
		registry.addViewController("/OtherTypeManage/OtherTypeManage").setViewName("OtherTypeManage/OtherTypeManage");
		registry.addViewController("/OtherTypeManage/TrafficWayManage").setViewName("OtherTypeManage/TrafficWayManage");
		registry.addViewController("/OtherTypeManage/RouteType").setViewName("OtherTypeManage/RouteType");
		registry.addViewController("/OtherTypeManage/RouteCategory").setViewName("OtherTypeManage/RouteCategory");
		registry.addViewController("/OtherTypeManage/InsuranceManagement").setViewName("OtherTypeManage/InsuranceManagement");
		registry.addViewController("/OtherTypeManage/InsuranceType").setViewName("OtherTypeManage/InsuranceType");
		registry.addViewController("/OtherTypeManage/SelfSupportRouteOtherInfo").setViewName("OtherTypeManage/SelfSupportRouteOtherInfo");
		registry.addViewController("/OtherTypeManage/VisaNationalsManage").setViewName("OtherTypeManage/VisaNationalsManage");
		registry.addViewController("/OtherTypeManage/Tabs").setViewName("OtherTypeManage/Tabs");
	}
}
