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
	
	@Modifying
	@Query(value = "update TourismTheme s set s.themeName = ?1 where s.id = ?2")
	public int update(String themeName, String id);

	@Modifying
	@Transactional
	@Query(value = "delete from TourismTheme s where s.themeName = ?1")
	public void delete1(String themeName);
	
	public void saveEm(TourismTheme tourismTheme);

	public void deleteEm(String id);
	
	public void updateEm(String themeName, String id);
	
	public TourismTheme findEm(String id);
	
}
