package org.honor.tourism.controller;

import java.util.Map;

import javax.validation.Valid;

import org.honor.tourism.entity.TourismTheme;
import org.honor.tourism.service.CrudService;
import org.honor.tourism.service.TourismThemeService;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@Autowired
	private TourismThemeService service;

	@RequestMapping("/saveJson")
	@ResponseBody
	public Map<String, Object> saveJson(@Valid @RequestBody TourismTheme t, BindingResult result) {
		if (result.hasErrors()) {//数据交验
			return EasyuiResult.result(result);
        }
		TourismTheme returnT = service.save(t);
		if (returnT == null) {
			EasyuiResult.result(false, "添加失败");
		}
		return EasyuiResult.result(true);
	}
	
}
