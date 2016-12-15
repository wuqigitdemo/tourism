package org.honor.tourism.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.honor.tourism.entity.SysUser;
import org.honor.tourism.service.SysUserService;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private SysUserService service;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping("/login") 
	public ModelAndView login(String username, String password, HttpServletRequest request) {
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);  
		System.out.println("用户名：" + userDetails.getUsername());
		System.out.println("密码：" + userDetails.getPassword());
		System.out.println("a...：" + userDetails.getAuthorities());
		Authentication authentication = new UsernamePasswordAuthenticationToken(    
		        userDetails, userDetails.getPassword(), userDetails.getAuthorities());
		SecurityContext securityContext = SecurityContextHolder.getContext();  
		securityContext.setAuthentication(authentication);  
		HttpSession session = request.getSession(true);  
		       session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
		       
		System.out.println("进入登录" + username + ":" + password);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		Map<String, Object> map = new HashMap<>();
		map.put("error", true);
//		map.put("logout", true);
		mav.addObject("abc", map);
		return mav;
	}
	
	@RequestMapping("/register")
	public @ResponseBody Map<String, Object> register(@Valid SysUser sysUser, BindingResult result) {
		if (result.hasErrors()) {
			return EasyuiResult.result(result);
        }
		SysUser saveSysUser = service.save(sysUser);
		if (saveSysUser == null) {
			return EasyuiResult.result(false);
		}
		return EasyuiResult.result(true);
	}
	
}
