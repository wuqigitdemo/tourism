package org.honor.tourism.controller;

import org.honor.tourism.entity.DiningType;
import org.honor.tourism.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用餐类型Controller
 * @author 刘海
 *
 */
@Controller
@RequestMapping("/DiningType")
public class DiningTypeController extends CrudController<DiningType> {

	@Autowired 
	public DiningTypeController(CrudService<DiningType> service) {
		super(service);
	}
}
