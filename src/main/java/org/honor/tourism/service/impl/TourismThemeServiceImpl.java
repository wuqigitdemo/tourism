package org.honor.tourism.service.impl;

import org.honor.tourism.entity.TourismTheme;
import org.honor.tourism.repository.TourismThemeRepository;
import org.honor.tourism.service.TourismThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TourismThemeServiceImpl extends CrudServiceImpl<TourismTheme> implements TourismThemeService {

	@Autowired
	public TourismThemeServiceImpl(JpaRepository<TourismTheme, String> repository) {
		super(repository);
	}
	@Autowired
	private TourismThemeRepository repository;
	
	@Transactional
	public int update(String themeName, String id) {
		return repository.update(themeName, id);
	}

	@Transactional
	public void delete1(String themeName) {
		repository.delete1(themeName);
	}
	
	@Transactional
	public void saveEm(TourismTheme tourismTheme) {
		repository.saveEm(tourismTheme);
	}
	
	@Transactional
	public void deleteEm(String id) {
		repository.deleteEm(id);
	}
	
	@Transactional
	public void updateEm(String themeName, String id) {
		repository.updateEm(themeName, id);
	}
	
	@Transactional
	public TourismTheme findEm(String id) {
		return repository.findEm(id);
	}

	
}
