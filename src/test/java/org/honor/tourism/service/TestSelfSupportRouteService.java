package org.honor.tourism.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.honor.tourism.Application;
import org.honor.tourism.entity.RouteBaseInfo;
import org.honor.tourism.entity.RouteTrip;
import org.honor.tourism.entity.SelfSupportRoute;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
public class TestSelfSupportRouteService {
	
	@Autowired
	private SelfSupportRouteService service;
	private RouteBaseInfoService routeBaseInfoService;
	
//	@Test
	public void delete() {
		service.deleteByRouteBaseInfoRouteName("4028b481599213fe015992140ecc0000");
	}
	
    @Test
	public void testSave() {
//		List<RouteTrip> routeTripList = new ArrayList<>();
//		RouteTrip routeTrip = new RouteTrip();
//		routeTrip.setTripTitle("测试行程123");
//		RouteTrip routeTrip2 = new RouteTrip();
//		routeTrip2.setTripTitle("测试行程456");
//		routeTripList.add(routeTrip);
//		routeTripList.add(routeTrip2);
		
		RouteBaseInfo routeBaseInfo = new RouteBaseInfo();
		routeBaseInfo.setRouteName("行程信息测试");
		routeBaseInfo.setOutPlace("哈尔滨2");
		routeBaseInfoService.save(routeBaseInfo);
		SelfSupportRoute selfSupportRoute = new SelfSupportRoute();
		selfSupportRoute.setCreateDate(new Date());
		selfSupportRoute.setUpdateDate(new Date());
		selfSupportRoute.setRouteBaseInfo(routeBaseInfo);
//		selfSupportRoute.setRouteTripList(routeTripList);
		SelfSupportRoute selfSupportRouteReturn = service.save(selfSupportRoute);
		System.out.println("##:" + selfSupportRouteReturn.getRouteBaseInfo().getRouteName());
		assertNotNull(selfSupportRouteReturn);
	}

}
