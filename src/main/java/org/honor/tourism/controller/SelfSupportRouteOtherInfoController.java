package org.honor.tourism.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.honor.tourism.entity.SelfSupportRouteOtherInfo;
import org.honor.tourism.service.SelfSupportRouteOtherInfoService;
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
 * 自营线路其他信息Controller
 * @author 刘海
 *
 */
@Controller
@RequestMapping("/SelfSupportRouteOtherInfo")
public class SelfSupportRouteOtherInfoController {
	
	@Autowired 
	private SelfSupportRouteOtherInfoService service;
	
	/**
	 * 获取自营线路其他信息
	 * @param page
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<SelfSupportRouteOtherInfo> pageSelfSupportRouteOtherInfo =  service.findAll(pageable);
		List<SelfSupportRouteOtherInfo> rows = pageSelfSupportRouteOtherInfo.getContent();
		Long total = service.count();
		return EasyuiResult.result(rows, total);
	}

	/**
	 * 新增和修改自营线路其他信息
	 * @param tourismTheme
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(@Valid SelfSupportRouteOtherInfo selfSupportRouteOtherInfo, BindingResult result) {
		if (result.hasErrors()) {//数据交验
			return EasyuiResult.result(result);
        }
		SelfSupportRouteOtherInfo returnSelfSupportRouteOtherInfo = service.save(selfSupportRouteOtherInfo);
		if (returnSelfSupportRouteOtherInfo == null) {
			EasyuiResult.result(false, "添加失败");
		}
		return EasyuiResult.result(true);
	}
	
	/**
	 * 删除自营线路其他信息
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
