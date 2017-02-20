package org.honor.tourism.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.honor.tourism.entity.SelfSupportRoute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class SelfSupportRouteRepositoryImpl {

	@PersistenceContext
	private EntityManager em;

	public Page<SelfSupportRoute> findByRouteBaseInfoRouteNameOrRouteBaseInfoOutPlaceOrRouteBaseInfoDestinationOrRouteBaseInfoRouteTypeListTypeName(
			String routeName, String outPlace, String destination, String typeName, Integer startDays, Integer endDays, Pageable pageable) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("from SelfSupportRoute ssr ");
		if (typeName != null && !"".equals(typeName)) {
			jpql.append(" join fetch ssr.routeBaseInfo.routeTypeList rtl");
		}
		jpql.append(" where 1=1");
		if (routeName != null && !"".equals(routeName)) {
			jpql.append(" and ssr.routeBaseInfo.routeName like :routeName");
		}
		if (outPlace != null && !"".equals(outPlace)) {
			jpql.append(" and ssr.routeBaseInfo.outPlace like :outPlace");
		}
		if (destination != null && !"".equals(destination)) {
			jpql.append(" and ssr.routeBaseInfo.destination like :destination");
		}
		if (typeName != null && !"".equals(typeName)) {
			jpql.append(" and rtl.typeName like :typeName");
		}
		if (startDays != null) {
			jpql.append(" and size(ssr.routeTripList) >= :startDays");
		}
		if (endDays != null) {
			jpql.append(" and size(ssr.routeTripList) <= :endDays");
		}
		TypedQuery<SelfSupportRoute> tq = em.createQuery(jpql.toString(), SelfSupportRoute.class);
		if (routeName != null && !"".equals(routeName)) {
			tq.setParameter("routeName", "%" + routeName + "%");
		}
		if (outPlace != null && !"".equals(outPlace)) {
			tq.setParameter("outPlace", "%" + outPlace + "%");
		}
		if (destination != null && !"".equals(destination)) {
			tq.setParameter("destination", "%" + destination + "%");
		}
		if (typeName != null && !"".equals(typeName)) {
			tq.setParameter("typeName", "%" + typeName + "%");
		}
		if (startDays != null) {
			tq.setParameter("startDays", startDays);
		}
		if (endDays != null) {
			tq.setParameter("endDays", endDays);
		}
		long total = tq.getResultList().size();
		tq.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		tq.setMaxResults(pageable.getPageSize());
		Page<SelfSupportRoute> page = new PageImpl<SelfSupportRoute>(tq.getResultList(), pageable, total);
		return page;
	}

}
