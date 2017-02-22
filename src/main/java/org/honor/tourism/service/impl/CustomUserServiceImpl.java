package org.honor.tourism.service.impl;

import org.honor.tourism.entity.SysUser;
import org.honor.tourism.repository.SysUserRepository;
import org.honor.tourism.service.MyInvocationSecurityMetadataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserServiceImpl implements UserDetailsService {

	@Autowired
	SysUserRepository userRepository;

	@Autowired
	MyInvocationSecurityMetadataSourceService invocation;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}else{
			invocation.loadResourceDefine();
			return user;
		}
	}

}
