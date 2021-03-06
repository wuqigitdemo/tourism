package org.honor.tourism.config;

import org.honor.tourism.service.MyInvocationSecurityMetadataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
	
	@Value("${custom.file.upload.path}")
	private String fileUploadPath;

	@Autowired
	MyInvocationSecurityMetadataSourceService invocation;
	
	/**
     * 自定义异常页
     */
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

       return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.FORBIDDEN, "/403");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500");
            container.addErrorPages(error401Page,error404Page, error500Page);
       });
    }
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/403").setViewName("403");
		registry.addViewController("/404").setViewName("404");
		registry.addViewController("/500").setViewName("500");
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
		registry.addViewController("/OtherTypeManage/VisaNationalsManage").setViewName("OtherTypeManage/VisaNationalsManage");
		registry.addViewController("/OtherTypeManage/HotelCategoriesManage").setViewName("OtherTypeManage/HotelCategoriesManage");
		registry.addViewController("/ProductBusinessManage/RouteManage/RouteBaseInfo").setViewName("ProductBusinessManage/RouteManage/RouteBaseInfo");
		registry.addViewController("/OtherTypeManage/DiningType").setViewName("OtherTypeManage/DiningType");
		registry.addViewController("/OtherTypeManage/PriceInventory").setViewName("OtherTypeManage/PriceInventory");
		registry.addViewController("/OtherTypeManage/FileUpload").setViewName("OtherTypeManage/FileUpload");
		registry.addViewController("/ProductBusinessManage/RouteManage/RouteBaseInfoUpdate").setViewName("ProductBusinessManage/RouteManage/RouteBaseInfoUpdate");
		registry.addViewController("/ProductBusinessManage/RouteManage/RouteBaseInfoView").setViewName("ProductBusinessManage/RouteManage/RouteBaseInfoView");
		registry.addViewController("/ProductBusinessManage/RouteManage/TablesAll").setViewName("ProductBusinessManage/RouteManage/TablesAll");
		registry.addViewController("/ProductBusinessManage/ScenicManagement").setViewName("/ProductBusinessManage/ScenicManagement");
		registry.addViewController("/ProductBusinessManage/ScenicManagementAdd").setViewName("/ProductBusinessManage/ScenicManagementAdd");
		registry.addViewController("/ProductBusinessManage/RouteManage/HotelManagement").setViewName("ProductBusinessManage/RouteManage/HotelManagement");
		registry.addViewController("/ProductBusinessManage/RouteManage/HotelManagementAdd").setViewName("ProductBusinessManage/RouteManage/HotelManagementAdd");
		registry.addViewController("/ProductBusinessManage/RouteManage/HotelManagementView").setViewName("ProductBusinessManage/RouteManage/HotelManagementView");
		registry.addViewController("/ProductBusinessManage/RouteManage/HotelManagementUpdate").setViewName("ProductBusinessManage/RouteManage/HotelManagementUpdate");
		registry.addViewController("/OtherTypeManage/HotelLevel").setViewName("OtherTypeManage/HotelLevel");
		registry.addViewController("/OtherTypeManage/City").setViewName("OtherTypeManage/City");
		registry.addViewController("/OtherTypeManage/HotelProvideService").setViewName("OtherTypeManage/HotelProvideService");
		registry.addViewController("/OtherTypeManage/Department").setViewName("OtherTypeManage/Department");
		registry.addViewController("/AuthorityManagement/ModuleManagement").setViewName("AuthorityManagement/ModuleManagement");
		registry.addViewController("/AuthorityManagement/RoleManagement").setViewName("AuthorityManagement/RoleManagement");
		registry.addViewController("/AuthorityManagement/DepartmentManagement").setViewName("AuthorityManagement/DepartmentManagement");
		registry.addViewController("/AuthorityManagement/StaffManagement").setViewName("AuthorityManagement/StaffManagement");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		StringBuffer sb = new StringBuffer();
		sb.append("file:");
		sb.append(fileUploadPath);
		registry.addResourceHandler("/files/**").addResourceLocations(sb.toString());
		super.addResourceHandlers(registry);
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(invocation);
		super.addInterceptors(registry);
	}
}
