package org.honor.tourism.service.impl;

import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.service.SelfSupportRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SelfSupportRouteServiceImpl extends CrudServiceImpl<SelfSupportRoute> implements SelfSupportRouteService {

	@Autowired
	public SelfSupportRouteServiceImpl(JpaRepository<SelfSupportRoute, String> repository) {
		super(repository);
	}

}
