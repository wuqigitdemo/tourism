package org.honor.tourism.service.impl;

import org.honor.tourism.entity.TourismTheme;
import org.honor.tourism.repository.TourismThemeRepository;
import org.honor.tourism.service.TourismThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TourismThemeServiceImpl implements TourismThemeService {
	
	@Autowired
	private TourismThemeRepository repository;

	@Override
	public Page<TourismTheme> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public TourismTheme save(TourismTheme tourismTheme) {
		return repository.save(tourismTheme);
	}

	@Override
	public void delete(String id) {
		repository.delete(id);
	}

}
