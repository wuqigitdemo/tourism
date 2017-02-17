package org.honor.tourism.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.honor.tourism.entity.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 * 作者:修罗大人
 * 日期:Feb 14, 2017
 * 时间:10:02:09 PM
 */

public class SysRoleRepositoryImpl {

	@PersistenceContext
	EntityManager em;
	
	/**
	 * 查询角色
	 * @param roleName
	 * @return
	 */
	public Page<SysRole> findRoles(String roleName,Pageable pageable)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("from SysRole role where 1 = 1");
		
		if (roleName != null && !roleName.equals("")) {
			sb.append(" and role.name like :roleName");
		}
		
		TypedQuery<SysRole> query = em.createQuery(sb.toString(), SysRole.class);
		
		if (roleName != null && !roleName.equals("")) {
			query.setParameter("roleName", "%"+roleName+"%");
		}
		
		long total = query.getResultList().size();
		query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		query.setMaxResults(pageable.getPageSize());
		List<SysRole> roles = query.getResultList();
		Page<SysRole> page = new PageImpl<>(roles, pageable, total);
		
		return page;
	}
}
