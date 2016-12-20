package org.honor.tourism.service.impl;

import org.honor.tourism.entity.VisaNationals;
import org.honor.tourism.repository.VisaNationalsRepository;
import org.honor.tourism.service.VisaNationalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VisaNationalsServiceImpl implements VisaNationalsService {
	
	@Autowired
	private VisaNationalsRepository repository;

	@Override
	public Page<VisaNationals> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public VisaNationals save(VisaNationals visaNationals) {
		return repository.save(visaNationals);
	}

	@Override
	public void delete(String id) {
		repository.delete(id);
	}

}
