package org.honor.tourism.repository;

import static org.junit.Assert.assertTrue;

import org.honor.tourism.Application;
import org.honor.tourism.entity.TourismTheme;
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
public class TestTourismThemeRepository {
	
	@Autowired
	private TourismThemeRepository repository;
	
    @Test
    public void testSave() throws Exception {
    	TourismTheme tt = new TourismTheme();
    	tt.setThemeName("Repository主题3");
    	TourismTheme returnTT = repository.save(tt);
    	assertTrue(returnTT.getThemeName().equals("Repository主题1"));
    }
    
}
