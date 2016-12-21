package org.honor.tourism.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.honor.tourism.entity.InsuranceType;
import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.entity.Traffic;
import org.honor.tourism.service.SelfSupportRouteBaseInfoService;
import org.honor.tourism.service.TrafficWayService;
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
 * 自营线路信息Controller
 *
 */
@Controller
@RequestMapping("/SelfSupportRoute")
public class SelfSupportRouteController {
	
	@Autowired 
	private SelfSupportRouteBaseInfoService service;
	
	@Autowired 
	private TrafficWayService trafficWayService;
	
	/**
	 * 获取自营线路信息
	 * @param page
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<SelfSupportRoute> pageSelfSupportRoute =  service.findAll(pageable);
		List<SelfSupportRoute> rows = pageSelfSupportRoute.getContent();
		Long total = service.count();
		return EasyuiResult.result(rows, total);
	}

	/**
	 * 新增和修改自营线路信息
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(@Valid SelfSupportRoute selfSupportRoute, BindingResult result) {
		if (result.hasErrors()) {//数据交验
			return EasyuiResult.result(result);
        }
		SelfSupportRoute returnSelfSupportRoute = service.save(selfSupportRoute);
		if (returnSelfSupportRoute == null) {
			EasyuiResult.result(false, "添加失败");
		}
		return EasyuiResult.result(true);
	}
	
	/**
	 * 删除自营线路信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(String id) {
		service.delete(id);
		return EasyuiResult.result(true);
	}
	
	/**
	 * 查询交通方式
	 * @param page
	 * @return
	 */
	@RequestMapping("/selectGoWay")
	@ResponseBody
	public List<Traffic> selectType() {
		Pageable pageable = new PageRequest(0, 100000);
		Page<Traffic> insuranceType =  trafficWayService.findAll(pageable);
		List<Traffic> rows = insuranceType.getContent();
		return rows;
	}

}
