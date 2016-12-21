package org.honor.tourism.service.impl;

import org.honor.tourism.entity.TourismTheme;
import org.honor.tourism.service.TourismThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TourismThemeServiceImpl extends CrudServiceImpl<TourismTheme> implements TourismThemeService {

	@Autowired
	public TourismThemeServiceImpl(JpaRepository<TourismTheme, String> repository) {
		super(repository);
	}
	
}
