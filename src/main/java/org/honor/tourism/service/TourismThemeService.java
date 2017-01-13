package org.honor.tourism.service;

import org.honor.tourism.entity.TourismTheme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 旅游主题Service
 * @author keiwu
 *
 */
public interface TourismThemeService extends CrudService<TourismTheme> {

	public int update(String themeName, String id);
	
	public void delete1(String themeName);
	
	public void saveEm(TourismTheme tourismTheme);
	
	public void deleteEm(String id);
	
	public void updateEm(String themeName, String id);
	
	public TourismTheme findEm(String id);
	
}
