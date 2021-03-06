package org.honor.tourism.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.honor.tourism.entity.InsuranceType;
import org.honor.tourism.service.InsuranceTypeService;
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
 * 保险种类Controller
 * @author 刘海
 *
 */
@Controller
@RequestMapping("/InsuranceType")
public class InsuranceTypeController {
	
	@Autowired 
	private InsuranceTypeService service;
	
	/**
	 * 获取保险种类
	 * @param page
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<InsuranceType> pageInsuranceType =  service.findAll(pageable);
		List<InsuranceType> rows = pageInsuranceType.getContent();
		Long total = service.count();
		return EasyuiResult.result(rows, total);
	}
	
	/**
	 * 新增和修改保险
	 * @param tourismTheme
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(@Valid InsuranceType insuranceType, BindingResult result) {
		if (result.hasErrors()) {//数据交验
			return EasyuiResult.result(result);
        }
		InsuranceType returnTourismTheme = service.save(insuranceType);
		if (returnTourismTheme == null) {
			EasyuiResult.result(false, "添加失败");
		}
		return EasyuiResult.result(true);
	}
	
	/**
	 * 删除保险
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
