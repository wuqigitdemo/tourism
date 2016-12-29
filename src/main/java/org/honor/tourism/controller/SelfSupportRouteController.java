package org.honor.tourism.controller;

import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;

public class SelfSupportRouteController extends CrudController<SelfSupportRoute> {

	@Autowired
	public SelfSupportRouteController(CrudService<SelfSupportRoute> service) {
		super(service);
	}

}
