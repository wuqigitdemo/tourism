package org.honor.tourism.service;

import java.util.ArrayList;
import java.util.List;

import org.honor.tourism.Application;
import org.honor.tourism.entity.Demo;
import org.honor.tourism.entity.DemoChildren;
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
public class TestDemoService {
	
	@Autowired
	private DemoService service;
	@Autowired
	private DemoChildrenService demoChildrenService;
	
	@Test
	public void save() {
		Demo demo = new Demo();
		demo.setDemoName("需要厅a$");
		
		DemoChildren dc = new DemoChildren();
		dc.setDemoChildrenName("载需要a$");
		dc.setDemo(demo);
		demo.setDemoChildren(dc);
		
		service.save(demo);
	}
	
//	@Test
	public void delete() {
		service.delete("402882b559b021870159b0219b350000");
	}
	
//	@Test
	public void update() {
		Demo demo = service.findById("402882b559aad5a00159aad5b2120000");
		demo.setDemoName("鍝堝＋濂囧姛");
		service.save(demo);
	}
	
	
//	@Test
	public void saveEm() {
		Demo demo = new Demo();
		demo.setDemoName("绾ц仈娴嬭瘯");
		DemoChildren dc = new DemoChildren();
		dc.setDemoChildrenName("绾ц仈娴嬭瘯瀛�");
		List<DemoChildren> list = new ArrayList<>();
		list.add(dc);
//		demo.setDemoChildrenList(list);
		service.save(demo);
	}
	
}
