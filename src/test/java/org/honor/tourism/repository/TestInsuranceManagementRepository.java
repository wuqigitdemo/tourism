package org.honor.tourism.repository;

import java.util.List;

import org.honor.tourism.Application;
import org.honor.tourism.entity.InsuranceManagement;
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
public class TestInsuranceManagementRepository {
	
	@Autowired
	private InsuranceManagementRepository repository;
	
	@Test
	public void findByInsuranceNameLike() {
		Pageable pageable = new PageRequest(0, 10);
		Page<InsuranceManagement> page = repository.findByInsuranceNameLike("vcv", pageable);
		List<InsuranceManagement> list = page.getContent();
		for (InsuranceManagement insuranceManagement : list) {
			System.out.println("name: " + insuranceManagement.getInsuranceName());
		}
	}

}
