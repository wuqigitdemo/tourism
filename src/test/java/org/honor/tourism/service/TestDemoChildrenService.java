package org.honor.tourism.service;

import org.honor.tourism.Application;
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

//	@Test
	public void testSave() {
		DemoChildren dc = new DemoChildren();
		dc.setDemoChildrenName("demoChildrenName要");
		service.save(dc);
	}
	
	@Test
	public void deleteQuery() {
		service.deleteQuery("402882b559ab05f90159ab06105f0001");
	}
	
}
