package org.honor.tourism.service;

import org.honor.tourism.Application;
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
	
	@Test
	public void delete() {
		service.deleteByRouteBaseInfoRouteName("4028b481599213fe015992140ecc0000");
	}

}
