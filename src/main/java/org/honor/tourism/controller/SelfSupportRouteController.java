package org.honor.tourism.controller;

import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.service.CrudService;
import org.honor.tourism.service.SelfSupportRouteService;
import org.honor.tourism.util.EasyuiPage;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/SelfSupportRoute")
public class SelfSupportRouteController extends CrudController<SelfSupportRoute> {
	
	@Autowired
	private SelfSupportRouteService service;

	@Autowired
	public SelfSupportRouteController(CrudService<SelfSupportRoute> service) {
		super(service);
	}

	@RequestMapping("/findByPar")
	@ResponseBody
	public Map<String, Object> findByPar(String routeName, String outPlace, String destination, String typeName, EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		List<SelfSupportRoute> rows = service.findByRouteBaseInfoRouteNameOrRouteBaseInfoOutPlaceOrRouteBaseInfoDestinationOrRouteBaseInfoRouteTypeListTypeName(routeName, "", "", "", pageable);
		Long total = service.count();
		return EasyuiResult.result(rows, total);
	}

}
