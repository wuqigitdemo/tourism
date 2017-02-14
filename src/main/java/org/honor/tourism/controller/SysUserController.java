package org.honor.tourism.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.honor.tourism.entity.SysUser;
import org.honor.tourism.service.CrudService;
import org.honor.tourism.service.SysUserService;
import org.honor.tourism.util.EasyuiPage;
import org.honor.tourism.util.EasyuiResult;
import org.honor.tourism.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 作者:修罗大人
 * 日期:Feb 8, 2017
 * 时间:9:29:12 AM
 * SysUserController
 */
@Controller
@RequestMapping("/SysUserController")
public class SysUserController extends CrudController<SysUser> {

	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
	public SysUserController(CrudService<SysUser> service) {
		super(service);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 批量删除员工
	 * @param userIds
	 * @return
	 */
	@RequestMapping(value = "/deleteUsers",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteUsers(@RequestBody List<String> userIds) {
		try {
			sysUserService.deleteUsers(userIds);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("批量删除员工错误");
			e.printStackTrace();
			return EasyuiResult.result(false,"操作失败");
		}
		
		return EasyuiResult.result(true,"操作成功");
	}

	/**
	 * 查找单个员工详细信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findById",method = RequestMethod.POST)
	@ResponseBody
	public SysUser findById(String id) {
		
		SysUser users = sysUserService.findById(id);
		return users;
	}
	
	/**
	 * 查询员工
	 * @param name
	 * @param username
	 * @param deptId
	 * @param page
	 * @return
	 */
	@RequestMapping("/findUsers")
	@ResponseBody
	public Map<String, Object> findUsers(String name,String username,String deptId, EasyuiPage page) {
		Pageable pageable = new PageRequest(page.getPage(), page.getRows());
		Page<SysUser> pageList =  sysUserService.findUsersByNameAndUsernameAndDeptId(name,username,deptId, pageable);
		List<SysUser> rows = pageList.getContent();
		long total = pageList.getTotalElements();
		return EasyuiResult.result(rows, total);
	}
	
	/**
	 * 初始化员工密码
	 * @param userId
	 * @param passwrod
	 * @return
	 */
	@RequestMapping("/resetPassword")
	@ResponseBody
	public Map<String, Object> resetPassword(String userId,String passwrod)
	{
	
			if(sysUserService.resetPassword(userId, "123456") != null)
			{
				return EasyuiResult.result(true);
			}

			return EasyuiResult.result(false,"初始化员工密码失败");
	}
	
	/**
	 * 导入员工excel
	 * @param fileInputStream
	 * @return
	 */
	@RequestMapping("/inputUsersExcel")
	@ResponseBody
	public Map<String, Object> inputUsersExcel (@RequestParam("fileUpload") MultipartFile file){
		
		InputStream inputStream;
		try
		{
			inputStream = file.getInputStream();
			sysUserService.inputUsersExcel(inputStream);
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return EasyuiResult.result(false);
		}
		
		return EasyuiResult.result(true);
	}
	
	public SysUserService getSysUserService()
	{
		return sysUserService;
	}

	public void setSysUserService(SysUserService sysUserService)
	{
		this.sysUserService = sysUserService;
	}
}
