package org.honor.tourism.repository;

import org.honor.tourism.entity.TourismTheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * 旅游主题Repository
 * @author keiwu
 *
 */
public interface TourismThemeRepository extends JpaRepository<TourismTheme, String> {
	
}
