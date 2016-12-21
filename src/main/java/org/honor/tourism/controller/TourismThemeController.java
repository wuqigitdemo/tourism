package org.honor.tourism.controller;

import org.honor.tourism.entity.TourismTheme;
import org.honor.tourism.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 旅游主题Controller
 * @author keiwu
 *
 */
@Controller
@RequestMapping("/TourismTheme")
public class TourismThemeController extends CrudController<TourismTheme> {

	@Autowired 
	public TourismThemeController(CrudService<TourismTheme> service) {
		super(service);
	}

}
