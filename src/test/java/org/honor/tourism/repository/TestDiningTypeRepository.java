package org.honor.tourism.repository;

import java.util.List;

import org.honor.tourism.Application;
import org.honor.tourism.entity.DiningType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestDiningTypeRepository {

	@Autowired
	private DiningTypeRepository repository;
	
	@Test
	public void testFindAll() {
		List<DiningType> list = repository.findAll();
		for (DiningType diningType : list) {
			System.out.println("----------------:" + diningType.getTypeName());
		}
	}
	
}
