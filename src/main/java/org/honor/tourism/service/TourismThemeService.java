package org.honor.tourism.service;

import org.honor.tourism.entity.TourismTheme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 旅游主题Service
 * @author keiwu
 *
 */
public interface TourismThemeService {

	public Page<TourismTheme> findAll(Pageable pageable);
	
	public Long count();
	
	public TourismTheme save(TourismTheme tourismTheme);
	
	public void delete(String id);
	
}
