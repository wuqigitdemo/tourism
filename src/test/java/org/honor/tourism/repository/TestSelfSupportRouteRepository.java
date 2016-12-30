package org.honor.tourism.repository;

import java.util.Date;
import static org.junit.Assert.*;
import org.honor.tourism.Application;
import org.honor.tourism.entity.SelfSupportRoute;
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
	
	@Test
	public void save() {
		SelfSupportRoute selfSupportRoute = new SelfSupportRoute();
		selfSupportRoute.setCreateDate(new Date());
		SelfSupportRoute selfSupportRouteReturn = repository.save(selfSupportRoute);
		assertNotNull(selfSupportRouteReturn);
	}
}
