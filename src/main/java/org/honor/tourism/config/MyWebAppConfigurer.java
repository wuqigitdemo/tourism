package org.honor.tourism.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
	
	@Value("${custom.file.upload.path}")
	private String fileUploadPath;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/register").setViewName("register");
		registry.addViewController("/welcome").setViewName("welcome");
		registry.addViewController("/OtherTypeManage/TourismTheme").setViewName("OtherTypeManage/TourismTheme");
		registry.addViewController("/OtherTypeManage/TrafficWayManage").setViewName("OtherTypeManage/TrafficWayManage");
		registry.addViewController("/OtherTypeManage/RouteType").setViewName("OtherTypeManage/RouteType");
		registry.addViewController("/OtherTypeManage/RouteCategory").setViewName("OtherTypeManage/RouteCategory");
		registry.addViewController("/OtherTypeManage/InsuranceManagement").setViewName("OtherTypeManage/InsuranceManagement");
		registry.addViewController("/OtherTypeManage/InsuranceType").setViewName("OtherTypeManage/InsuranceType");
		registry.addViewController("/OtherTypeManage/SelfSupportRoute").setViewName("OtherTypeManage/SelfSupportRoute");
		registry.addViewController("/OtherTypeManage/SelfSupportRouteOtherInfo").setViewName("OtherTypeManage/SelfSupportRouteOtherInfo");
		registry.addViewController("/OtherTypeManage/VisaNationalsManage").setViewName("OtherTypeManage/VisaNationalsManage");
		registry.addViewController("/OtherTypeManage/HotelCategoriesManage").setViewName("OtherTypeManage/HotelCategoriesManage");
		registry.addViewController("/OtherTypeManage/SelfSupportRouteBaseInfo").setViewName("OtherTypeManage/SelfSupportRouteBaseInfo");
		registry.addViewController("/OtherTypeManage/Tabs").setViewName("OtherTypeManage/Tabs");
		registry.addViewController("/OtherTypeManage/DiningType").setViewName("OtherTypeManage/DiningType");
		registry.addViewController("/OtherTypeManage/PriceInventory").setViewName("OtherTypeManage/PriceInventory");
		registry.addViewController("/OtherTypeManage/FileUpload").setViewName("OtherTypeManage/FileUpload");
		registry.addViewController("/OtherTypeManage/OtherInfo").setViewName("OtherTypeManage/OtherInfo");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		StringBuffer sb = new StringBuffer();
		sb.append("file:");
		sb.append(fileUploadPath);
		registry.addResourceHandler("/files/**").addResourceLocations(sb.toString());
		super.addResourceHandlers(registry);
	}

}
