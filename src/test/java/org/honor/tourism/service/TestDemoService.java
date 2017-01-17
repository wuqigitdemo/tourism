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
	
//	@Test
	public void save() {
		Demo demo = new Demo();
		demo.setDemoName("demo3");
		
		DemoChildren dc = new DemoChildren();
		dc.setDemoChildrenName("zi3");
		
		List<DemoChildren> list = new ArrayList<>();
		list.add(dc);
		
		demo.setDemoChildrenList(list);
		
		service.save(demo);
	}
	
//	@Test
	public void delete() {
		service.delete("402882b559ab2a750159ab2a86f30000");
	}
	
//	@Test
	public void update() {
		Demo demo = service.findById("402882b559aad5a00159aad5b2120000");
		demo.setDemoName("哈士奇功");
		service.save(demo);
	}
	
//	@Test
	public void deleteByDemoName() {
		service.deleteByDemoName("哈士奇功");
	}
	
//	@Test
	public void saveEm() {
		Demo demo = new Demo();
		demo.setDemoName("级联测试");
		DemoChildren dc = new DemoChildren();
		dc.setDemoChildrenName("级联测试子");
		List<DemoChildren> list = new ArrayList<>();
		list.add(dc);
		demo.setDemoChildrenList(list);
		service.save(demo);
	}
	
//	@Test
	public void deleteEm() {
		service.deleteEm("402882b559aad8f00159aad905100001");
	}
	
//	@Test
	public void updateEm() {
		service.updateEm("402882b559ab05f90159ab0610310000");
	}
	
//	@Test
	public void findByIdEm() {
		Demo demo = service.findByIdEm("402882b559ab05f90159ab0610310000");
		System.out.println("查询出来的名称：" + demo.getDemoChildrenList().get(0).getDemoChildrenName());
	}
	
//	@Test
	public void deleteQuery() {
		service.deleteQuery("402882b559ab2a750159ab2a86f30000");
	}
	
//	@Test
	public void updateQuery() {
		service.updateQuery("demo11", "402882b559ab2a3c0159ab2a4c6a0000");
	}
	
//	@Test
	public void findQuery() {
		List<Demo> list = service.findQuery("zi3");
		for (Demo demo : list) {
			System.out.println("查询的级联：" + demo.getDemoName());
		}
	}
	
//	@Test
	public void deleteByDemoChildrenListDemoChildrenName() {
		service.deleteByDemoChildrenListDemoChildrenName("zi3");
	}
	
	@Test
	public void deleteByDemoNameEm() {
		service.deleteByDemoNameEm("402882b559ab2a750159ab2a86f30000");
	}

}
