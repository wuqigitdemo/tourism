package org.honor.tourism.controller;

import java.util.List;

import org.honor.tourism.entity.DiningType;
import org.honor.tourism.service.CrudService;
import org.honor.tourism.service.DiningTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用餐类型Controller
 * @author 刘海
 *
 */
@Controller
@RequestMapping("/DiningType")
public class DiningTypeController extends CrudController<DiningType> {
	
	@Autowired 
	private DiningTypeService service;

	@Autowired 
	public DiningTypeController(CrudService<DiningType> service) {
		super(service);
	}
	
	/**
	 * 获取线路类别
	 * @param page
	 * @return
	 */
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<DiningType> selectAll() {
		List<DiningType> diningTypes =  service.findAll();
		return diningTypes;
	}
	
}
