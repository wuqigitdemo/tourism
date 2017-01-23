package org.honor.tourism.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.honor.tourism.entity.InsuranceManagement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class InsuranceManagementRepositoryImpl {

	@PersistenceContext
	private EntityManager em;

	public Page<InsuranceManagement> findByInsuranceNameLike(String insuranceName, Pageable pageable) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("from InsuranceManagement ssr where 1=1");
		if (insuranceName != null && !"".equals(insuranceName)) {
			jpql.append(" and ssr.insuranceName like :insuranceName");
		}
		
		TypedQuery<InsuranceManagement> tq = em.createQuery(jpql.toString(), InsuranceManagement.class);
		if (insuranceName != null && !"".equals(insuranceName)) {
			tq.setParameter("insuranceName", "%" + insuranceName + "%");
		}
	
		long total = tq.getResultList().size();
		tq.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		tq.setMaxResults(pageable.getPageSize());
		Page<InsuranceManagement> page = new PageImpl<InsuranceManagement>(tq.getResultList(), pageable, total);
		return page;
	}

}
