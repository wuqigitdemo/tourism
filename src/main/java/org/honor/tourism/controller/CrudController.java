package org.honor.tourism.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.honor.tourism.service.CrudService;
import org.honor.tourism.util.EasyuiPage;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 封装的增册改查Controller
 * @author keiwu

 * @param <T>
 */
public class CrudController<T> {
	
	private CrudService<T> service;
	
	public CrudController(CrudService<T> service) {
		this.service = service;
	}

	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<T> t =  service.findAll(pageable);
		List<T> rows = t.getContent();
		Long total = service.count();
		return EasyuiResult.result(rows, total);
	}

	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(@Valid T t, BindingResult result) {
		if (result.hasErrors()) {//数据交验
			return EasyuiResult.result(result);
        }
		
		try {
			T returnT = service.save(t);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("添加失败");
			e.printStackTrace();
			return EasyuiResult.result(false, "添加失败");
		}
		
		return EasyuiResult.result(true);
	}
	
	/**
	 * 删除旅游主题
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(String id) {
		service.delete(id);
		return EasyuiResult.result(true);
	}
	


}
