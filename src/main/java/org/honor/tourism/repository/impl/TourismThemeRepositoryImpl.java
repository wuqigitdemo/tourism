package org.honor.tourism.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.honor.tourism.entity.TourismTheme;

public class TourismThemeRepositoryImpl {

	@PersistenceContext
	private EntityManager em;

	public void saveEm(TourismTheme tourismTheme) {
		em.persist(tourismTheme);
	}
	
	public void deleteEm(String id) {
		TourismTheme tourismTheme = em.find(TourismTheme.class, id);
		em.remove(tourismTheme);
	}
	
	public void updateEm(String themeName, String id) {
		TourismTheme tourismTheme = em.find(TourismTheme.class, id);
		tourismTheme.setThemeName(themeName);
	}
	
	public TourismTheme findEm(String id) {
		return em.find(TourismTheme.class, id);
	}
	
}
