package org.honor.tourism.repository;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import org.honor.tourism.Application;
import org.honor.tourism.entity.RouteBaseInfo;
import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.service.RouteBaseInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
//	@Test
	public void testSave() {
		RouteBaseInfo routeBaseInfo = new RouteBaseInfo();
		routeBaseInfo.setRouteName("测试基础名称3");
		routeBaseInfo.setOutPlace("哈尔滨2");
//		routeBaseInfoService.save(routeBaseInfo);
		SelfSupportRoute selfSupportRoute = new SelfSupportRoute();
		selfSupportRoute.setCreateDate(new Date());
		selfSupportRoute.setUpdateDate(new Date());
		selfSupportRoute.setRouteBaseInfo(routeBaseInfo);
		SelfSupportRoute selfSupportRouteReturn = repository.save(selfSupportRoute);
		assertNotNull(selfSupportRouteReturn);
	}
	
	@Test
	public void testFindByRouteBaseInfoRouteName() {
		Pageable pageable = new PageRequest(0, 5);
		Page<SelfSupportRoute> page = repository.findByRouteBaseInfoRouteNameOrRouteBaseInfoOutPlaceOrRouteBaseInfoDestinationOrRouteBaseInfoRouteTypeListTypeName("", "","", "", pageable);
		List<SelfSupportRoute> list = page.getContent();
		System.out.println("总数2：" + page.getTotalElements());
		for (SelfSupportRoute selfSupportRoute : list) {
			System.out.println(selfSupportRoute.getRouteBaseInfo().getRouteName());
		}
	}
	
}
