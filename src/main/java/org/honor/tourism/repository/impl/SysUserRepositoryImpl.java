package org.honor.tourism.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import org.honor.tourism.entity.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 * 作者:修罗大人
 * 日期:Feb 9, 2017
 * 时间:10:27:39 AM
 */

public class SysUserRepositoryImpl {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 根据条件查询员工
	 * @param name
	 * @param username
	 * @param deptId
	 */
	public Page<SysUser> findUsersByNameAndUsernameAndDeptId(String name,String username,String deptId,Pageable pageable)
	{
		StringBuffer jpql = new StringBuffer();
		jpql.append("from SysUser su ");
		
		jpql.append(" where 1=1");
		
		if (deptId != null && !"".equals(deptId)) {
			jpql.append(" and su.department.id = :deptId");
		}
		
		if (name != null && !"".equals(name)) {
			jpql.append(" and su.name like :name");
		}
		
		if (username != null && !"".equals(username)) {
			jpql.append(" and su.username like :username");
		}
		
		TypedQuery<SysUser> tq = em.createQuery(jpql.toString(), SysUser.class);

		if (deptId != null && !"".equals(deptId)) {
			tq.setParameter("deptId", deptId);
		}
		
		if (name != null && !"".equals(name)) {
			tq.setParameter("name", "%" + name + "%");
		}
		
		if (username != null && !"".equals(username)) {
			tq.setParameter("username", "%" + username + "%");
		}
		
		long total = tq.getResultList().size();
		tq.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		tq.setMaxResults(pageable.getPageSize());
		Page<SysUser> page = new PageImpl<SysUser>(tq.getResultList(), pageable, total);
		return page;
	}
	
}
