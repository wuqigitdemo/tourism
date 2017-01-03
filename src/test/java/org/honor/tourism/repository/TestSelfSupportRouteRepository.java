package org.honor.tourism.repository;

import java.util.Date;
import static org.junit.Assert.*;
import org.honor.tourism.Application;
import org.honor.tourism.entity.RouteBaseInfo;
import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.service.RouteBaseInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestSelfSupportRouteRepository {

	@Autowired
	private SelfSupportRouteRepository repository;
	@Autowired
	private RouteBaseInfoService routeBaseInfoService;
	
	@Test
	public void save() {
		RouteBaseInfo routeBaseInfo = new RouteBaseInfo();
		routeBaseInfo.setRouteName("测试基础名称");
		routeBaseInfo.setOutPlace("哈尔滨");
//		routeBaseInfoService.save(routeBaseInfo);
		SelfSupportRoute selfSupportRoute = new SelfSupportRoute();
		selfSupportRoute.setCreateDate(new Date());
		selfSupportRoute.setUpdateDate(new Date());
		selfSupportRoute.setRouteBaseInfo(routeBaseInfo);
		SelfSupportRoute selfSupportRouteReturn = repository.save(selfSupportRoute);
		assertNotNull(selfSupportRouteReturn);
	}
}
