package org.honor.tourism.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.honor.tourism.entity.ScenicManagement;
import org.honor.tourism.service.ScenicManagementService;
import org.honor.tourism.util.EasyuiPage;
import org.honor.tourism.util.EasyuiResult;
import org.honor.tourism.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author 刘海 景区管理controller
 */
@Controller
@RequestMapping("/ScenicManagement")
public class ScenicManagementController {

	@Autowired
	public ScenicManagementService service;

	@Autowired
	private FileUpload fileUpload;

	/**
	 * 获取景区信息
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<ScenicManagement> pageScenicManagement = service.findAll(pageable);
		List<ScenicManagement> rows = pageScenicManagement.getContent();
		Long total = service.count();
		return EasyuiResult.result(rows, total);
	}
	
	  /**
		 * 根据id获取景区信息
		 * @param page
		 * @return
		 */
		@RequestMapping("/findScenicById")
		public String findScenicById(ModelMap model,String scenicId) {
			if(scenicId!=null&&!"".equals(scenicId)){
				ScenicManagement  scenicManagement=  service.findScenicById(scenicId);
				model.addAttribute("scenicManagement", scenicManagement);
			}
			return "/ProductBusinessManage/ScenicManagementSee";
		}

	/**
	 * 新增和修改景区信息
	 * 
	 * @param ScenicManagement
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(@Valid @RequestBody ScenicManagement scenicManagement, BindingResult result) {
		if (result.hasErrors()) {// 数据交验
			return EasyuiResult.result(result);
		}
		ScenicManagement returnScenicManagement = service.save(scenicManagement);
		if (returnScenicManagement == null) {
			EasyuiResult.result(false, "添加失败");
		}
		return EasyuiResult.result(true);
	}
	
	/**
	 * 修改进去信息
	 * @param model
	 * @param scenicId
	 * @return
	 */
	@RequestMapping(value = "/basicInformationUpdateHtml",method = RequestMethod.GET)
	public String modifyScenic (ModelMap model, String scenicId) {
		
		ScenicManagement scenicManagement = service.modifyScenicById(scenicId);
		
		model.addAttribute("scenicManagement", scenicManagement);
		return "/ProductBusinessManage/ScenicManagementModify";
	}

	/**
	 * 删除线路类别
	 * 
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
	 * 单文件上传
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping("/fileUpload")
	@ResponseBody
	public String fileUpload(@RequestParam("uploadFile") MultipartFile file) {
		String fileName = fileUpload.uploadFile(file);
		if (fileName != null) {
			return fileName;
		}
		return "false";
	}

	/**
	 * 多文件上传
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping("/multipleFileUpload")
	@ResponseBody
	public List<Map<String, String>> multipleFileUpload(@RequestParam("uploadMultipleFile") MultipartFile[] file) {
		List<Map<String, String>> returnList = new ArrayList<>();
		String fileName = "";
		for (MultipartFile multipartFile : file) {
			fileName = fileUpload.uploadFile(multipartFile);
			if (fileName == null) {
				return null;
			}
			Map<String, String> map = new HashMap<>();
			map.put("imageAddress", fileName);
			returnList.add(map);
		}
		return returnList;
	}

	@RequestMapping("/findByScenicNumberOrScenicName")
	@ResponseBody
	public Map<String, Object> findByScenicNumberOrScenicName(String scenicName, Integer scenicNumber, EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<ScenicManagement> pageList = service.findByScenicNumberOrScenicName(scenicName,scenicNumber,pageable);
		List<ScenicManagement> rows = pageList.getContent();
		long total = pageList.getTotalElements();
		return EasyuiResult.result(rows, total);
	}

}
