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
		registry.addViewController("/ProductBusinessManage/RouteManage/RouteType").setViewName("ProductBusinessManage/RouteManage/RouteType");
		registry.addViewController("/ProductBusinessManage/RouteManage/RouteCategory").setViewName("ProductBusinessManage/RouteManage/RouteCategory");
		registry.addViewController("/ProductBusinessManage/RouteManage/InsuranceManagement").setViewName("ProductBusinessManage/RouteManage/InsuranceManagement");
		registry.addViewController("/OtherTypeManage/InsuranceType").setViewName("OtherTypeManage/InsuranceType");
		registry.addViewController("/ProductBusinessManage/RouteManage/SelfSupportRoute").setViewName("/ProductBusinessManage/RouteManage/SelfSupportRoute");
		registry.addViewController("/OtherTypeManage/SelfSupportRouteOtherInfo").setViewName("OtherTypeManage/SelfSupportRouteOtherInfo");
		registry.addViewController("/OtherTypeManage/VisaNationalsManage").setViewName("OtherTypeManage/VisaNationalsManage");
		registry.addViewController("/OtherTypeManage/HotelCategoriesManage").setViewName("OtherTypeManage/HotelCategoriesManage");
		registry.addViewController("/ProductBusinessManage/RouteManage/RouteBaseInfo").setViewName("ProductBusinessManage/RouteManage/RouteBaseInfo");
		registry.addViewController("/ProductBusinessManage/RouteManage/SelfSupportRouteAdd").setViewName("/ProductBusinessManage/RouteManage/SelfSupportRouteAdd");
		registry.addViewController("/ProductBusinessManage/RouteManage/SelfSupportRouteUpdate").setViewName("/ProductBusinessManage/RouteManage/SelfSupportRouteUpdate");
		registry.addViewController("/OtherTypeManage/DiningType").setViewName("OtherTypeManage/DiningType");
		registry.addViewController("/OtherTypeManage/RouteTrip").setViewName("OtherTypeManage/RouteTrip");
		registry.addViewController("/OtherTypeManage/PriceInventory").setViewName("OtherTypeManage/PriceInventory");
		registry.addViewController("/OtherTypeManage/FileUpload").setViewName("OtherTypeManage/FileUpload");
		registry.addViewController("/ProductBusinessManage/RouteManage/OtherInfo").setViewName("ProductBusinessManage/RouteManage/OtherInfo");
		registry.addViewController("/ProductBusinessManage/RouteManage/RouteInsurance").setViewName("ProductBusinessManage/RouteManage/RouteInsurance");
		registry.addViewController("/ProductBusinessManage/RouteManage/PriceInventoryUpdate").setViewName("ProductBusinessManage/RouteManage/PriceInventoryUpdate");
		registry.addViewController("/ProductBusinessManage/RouteManage/RouteBaseInfoUpdate").setViewName("ProductBusinessManage/RouteManage/RouteBaseInfoUpdate");
		registry.addViewController("/ProductBusinessManage/RouteManage/PriceInventoryView").setViewName("ProductBusinessManage/RouteManage/PriceInventoryView");
		registry.addViewController("/ProductBusinessManage/RouteManage/OtherInfoView").setViewName("ProductBusinessManage/RouteManage/OtherInfoView");
		registry.addViewController("/ProductBusinessManage/RouteManage/RouteBaseInfoView").setViewName("ProductBusinessManage/RouteManage/RouteBaseInfoView");
		registry.addViewController("/OtherTypeManage/datagrid_data").setViewName("OtherTypeManage/datagrid_data");
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
