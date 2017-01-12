package org.honor.tourism.service;

import static org.junit.Assert.assertTrue;

import org.honor.tourism.Application;
import org.honor.tourism.entity.TourismTheme;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestTourismThemeService {

	@Autowired
	private TourismThemeService service;

	// @Test
	public void testSave() throws Exception {
		TourismTheme tt = new TourismTheme();
		tt.setThemeName("主题1");
		TourismTheme returnTT = service.save(tt);
		assertTrue(returnTT.getThemeName().equals("主题1"));
	}

	// @Test
	public void update() {
		service.update("主题2", "4028b4815992c5fa015992c60b0c0000");
	}

	// @Test
	public void delete1() {
		service.delete1("主题2");
		;
	}

//	@Test
	public void saveEm() {
		TourismTheme tt = new TourismTheme();
		tt.setThemeName("主题em");
		service.saveEm(tt);
	}

//	@Test
	public void deleteEm() {
		service.deleteEm("4028b4815992c68b015992c69a700000");
	}
	
//	@Test
	public void updateEm() {
		service.updateEm("主题888", "4028b4815992c647015992c65a930000");
	}

	@Test
	public void findEm() {
		TourismTheme tourismTheme = service.findEm("4028b4815992c647015992c65a930000");
		System.out.println(tourismTheme.getThemeName());
	}
	
}
