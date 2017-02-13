package org.honor.tourism.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.honor.tourism.entity.HotelManagement;
import org.honor.tourism.entity.InsuranceManagement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class HotelManagementRepositoryImpl {

	@PersistenceContext
	private EntityManager em;

	public Page<HotelManagement> findSearch(String hotelName,String phone,String levelName, String cityName,Pageable pageable){
		StringBuffer jpql = new StringBuffer();
		jpql.append("from HotelManagement hm where 1=1");
		if (hotelName != null && !"".equals(hotelName)) {
			jpql.append(" and hm.hotelName like :hotelName");
		}
		if (phone != null && !"".equals(phone)) {
			jpql.append(" and hm.phone like :phone");
		}
		if (levelName != null && !"".equals(levelName)) {
			jpql.append(" and hm.hotelLevel.levelName like :levelName");
		}
		if (cityName != null && !"".equals(cityName)) {
			jpql.append(" and hm.city.cityName like :cityName");
		}
		
		TypedQuery<HotelManagement> tq = em.createQuery(jpql.toString(), HotelManagement.class);
		if (hotelName != null && !"".equals(hotelName)) {
			tq.setParameter("hotelName", "%" + hotelName + "%");
		}
		if (phone != null && !"".equals(phone)) {
			tq.setParameter("phone", "%" + phone + "%");
		}
		if (levelName != null && !"".equals(levelName)) {
			tq.setParameter("levelName", "%" + levelName + "%");
		}
		if (cityName != null && !"".equals(cityName)) {
			tq.setParameter("cityName", "%" + cityName + "%");
		}
	
		long total = tq.getResultList().size();
		tq.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		tq.setMaxResults(pageable.getPageSize());
		Page<HotelManagement> page = new PageImpl<HotelManagement>(tq.getResultList(), pageable, total);
	    return page;
	}
	

}
