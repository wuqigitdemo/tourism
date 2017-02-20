package org.honor.tourism.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.honor.tourism.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 * 作者:修罗大人
 * 日期:Feb 9, 2017
 * 时间:10:27:39 AM
 */

public class DepartmentRepositoryImpl {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 根据条件查询部门
	 * @param departmentName
	 * @param parentDepartmentId
	 * @param delFlag
	 * @return
	 */
	public Page<Department> findDepts(String departmentName,String parentDepartmentId,String delFlag,Pageable pageable)
	{
		StringBuffer jpql = new StringBuffer();
		jpql.append("from Department su ");
		
		jpql.append(" where 1=1");
		
		if (departmentName != null && !"".equals(departmentName)) {
			jpql.append(" and su.departmentName like :departmentName");
		}
		
		if (parentDepartmentId != null && !"".equals(parentDepartmentId)) {
			jpql.append(" and su.parentDepartment.id = :parentDepartmentId");
		}
		
		TypedQuery<Department> tq = em.createQuery(jpql.toString(), Department.class);

		if (departmentName != null && !"".equals(departmentName)) {
			tq.setParameter("departmentName", "%" + departmentName + "%");
		}
		
		if (parentDepartmentId != null && !"".equals(parentDepartmentId)) {
			tq.setParameter("parentDepartmentId", parentDepartmentId);
		}
		
		long total = tq.getResultList().size();
		tq.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		tq.setMaxResults(pageable.getPageSize());
		Page<Department> page = new PageImpl<Department>(tq.getResultList(), pageable, total);
		return page;
	}
}
