package org.honor.tourism.service;

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
public class TestDemoChildrenService {
	
	@Autowired
	private DemoChildrenService service;

	@Test
	public void testSave() {

		Demo demo = new Demo();
		demo.setDemoName("#$%");
		DemoChildren dc = new DemoChildren();
		demo.setDemoChildren(dc);
		
		dc.setDemoChildrenName("&*(WSS");
		dc.setDemo(demo);
		service.save(dc);
	}
	
	
	@Test
	public void findById() {
		DemoChildren dc = service.findById("402882b559b074980159b074aae70000");
		System.out.println("子类名称：" + dc.getDemo().getDemoName());
	}
	
//	@Test
	public void deleteById() {
		service.delete("402882b559b022950159b022a5930001");
	}
	
}
