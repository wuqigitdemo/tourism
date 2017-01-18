package org.honor.tourism.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import org.honor.tourism.Application;
import org.honor.tourism.entity.RouteBaseInfo;
import org.honor.tourism.entity.RouteTrip;
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
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestSelfSupportRouteRepository {

	@Autowired
	private SelfSupportRouteRepository repository;
	@Autowired
	private RouteTripRepository routeTripRepository;
	
   //@Test
	public void testSave() {
		List<RouteTrip> routeTripList = new ArrayList<>();
		RouteTrip routeTrip = new RouteTrip();
		routeTrip.setTripTitle("测试行程123");
		RouteTrip routeTrip2 = new RouteTrip();
		routeTrip2.setTripTitle("测试行程456");
		routeTripList.add(routeTrip);
		routeTripList.add(routeTrip2);
		
		RouteBaseInfo routeBaseInfo = new RouteBaseInfo();
		routeBaseInfo.setRouteName("行程信息测试");
		routeBaseInfo.setOutPlace("哈尔滨2");
//		routeBaseInfoService.save(routeBaseInfo);
		SelfSupportRoute selfSupportRoute = new SelfSupportRoute();
		selfSupportRoute.setCreateDate(new Date());
		selfSupportRoute.setUpdateDate(new Date());
		selfSupportRoute.setRouteBaseInfo(routeBaseInfo);
		selfSupportRoute.setRouteTripList(routeTripList);
		SelfSupportRoute selfSupportRouteReturn = repository.save(selfSupportRoute);
		assertNotNull(selfSupportRouteReturn);
	}
	
	//@Test
	public void testFindByRouteBaseInfoRouteName() {
		Pageable pageable = new PageRequest(0, 5);
		Page<SelfSupportRoute> page = repository.findByRouteBaseInfoRouteNameOrRouteBaseInfoOutPlaceOrRouteBaseInfoDestinationOrRouteBaseInfoRouteTypeListTypeName(null, null,null, null, 0, 100, pageable);
		List<SelfSupportRoute> list = page.getContent();
		System.out.println("总数2：" + page.getTotalElements());
		for (SelfSupportRoute selfSupportRoute : list) {
			System.out.println("行程大小：" + selfSupportRoute.getRouteBaseInfo().getRouteName());
		}
	}
	
//	@Test
	public void testDelete() {
		SelfSupportRoute selfSupportRoute = repository.findOne("402882a6599073f70159907406200000");
		if(selfSupportRoute != null) {
			List<RouteTrip> list = selfSupportRoute.getRouteTripList();
			for (RouteTrip routeTrip : list) {
				System.out.println("xingcheng:" + routeTrip.getId());
				System.out.println("xingcheng:" + routeTrip.getTripTitle());
			}
		}
		System.out.println("执行");
		
	}
	
	@Test
	public void testDelete1() {
		String id = "4028b481599210330159921046f60000";
		 repository.deleteBy("4028b481599213fe015992140ecc0000", "abc");
	}
	
}
