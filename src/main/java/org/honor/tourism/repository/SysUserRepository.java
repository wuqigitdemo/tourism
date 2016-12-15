package org.honor.tourism.repository;

import org.honor.tourism.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser, String> {

	SysUser findByUsername(String username);

}
