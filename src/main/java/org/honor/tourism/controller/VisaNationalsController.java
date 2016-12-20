package org.honor.tourism.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.honor.tourism.entity.VisaNationals;
import org.honor.tourism.service.VisaNationalsService;
import org.honor.tourism.util.EasyuiPage;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 签证国家Controller
 * @author 刘海
 *
 */
@Controller
@RequestMapping("/VisaNationals")
public class VisaNationalsController {
	
	@Autowired 
	private VisaNationalsService service;
	
	/**
	 * 获取签证国家
	 * @param page
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<VisaNationals> pageVisaNationals =  service.findAll(pageable);
		List<VisaNationals> rows = pageVisaNationals.getContent();
		Long total = service.count();
		return EasyuiResult.result(rows, total);
	}

	/**
	 * 新增和修改签证国家
	 * @param tourismTheme
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(@Valid VisaNationals visaNationals, BindingResult result) {
		if (result.hasErrors()) {//数据交验
			return EasyuiResult.result(result);
        }
		VisaNationals returnVisaNationals = service.save(visaNationals);
		if (returnVisaNationals == null) {
			EasyuiResult.result(false, "添加失败");
		}
		return EasyuiResult.result(true);
	}
	
	/**
	 * 删除签证国家
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
