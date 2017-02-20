package org.honor.tourism.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.honor.tourism.entity.ScenicManagement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class ScenicManagementRepositoryImpl {
	
	@PersistenceContext
	private EntityManager em;
	
	public Page<ScenicManagement> findByScenicNumberOrScenicName(String scenicName,Integer scenicNumber, Pageable pageable) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("from ScenicManagement sm where 1=1");
		if (scenicName != null && !"".equals(scenicName)) {
			jpql.append(" and sm.scenicName like :scenicName");
		}

		if (scenicNumber != null && !"".equals(scenicNumber)) {
			jpql.append(" and sm.scenicNumber like :scenicNumber");
		}
		

		System.out.println(scenicName);
		TypedQuery<ScenicManagement> tq = em.createQuery(jpql.toString(), ScenicManagement.class);
		
		if (scenicName != null && !"".equals(scenicName)) {
			tq.setParameter("scenicName", "%" + scenicName + "%");
		}
		
		if (scenicNumber != null && !"".equals(scenicNumber)) {
			tq.setParameter("scenicNumber", "%" + scenicNumber + "%");
		}

		
		
		long total = tq.getResultList().size();
		tq.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		tq.setMaxResults(pageable.getPageSize());
		Page<ScenicManagement> page = new PageImpl<ScenicManagement>(tq.getResultList(), pageable, total);
		return page;
	}

}
