package org.honor.tourism.service.impl;

import org.honor.tourism.entity.SysUser;
import org.honor.tourism.repository.SysUserRepository;
import org.honor.tourism.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
	private SysUserRepository repository;

	@Override
	public SysUser save(SysUser sysUser) {
		return repository.save(sysUser);
	}

}
