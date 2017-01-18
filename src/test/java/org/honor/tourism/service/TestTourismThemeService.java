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

	 @Test
	public void testSave() throws Exception {
		TourismTheme tt = new TourismTheme();
		tt.setThemeName("主题1");
		TourismTheme returnTT = service.save(tt);
		assertTrue(returnTT.getThemeName().equals("主题1"));
	}

}
