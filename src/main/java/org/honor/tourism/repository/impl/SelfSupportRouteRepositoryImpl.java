package org.honor.tourism.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.honor.tourism.entity.PriceInventory;
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
		jpql.append("from SelfSupportRoute ssr where 1=1");// and size(ssr.routeTripList) > 1
		if (routeName != null && !"".equals(routeName)) {
			jpql.append("and ssr.routeBaseInfo.routeName like :routeName");
		}
		if (outPlace != null && !"".equals(outPlace)) {
			jpql.append("and ssr.routeBaseInfo.outPlace like :outPlace");
		}
		if (destination != null && !"".equals(destination)) {
			jpql.append("and ssr.routeBaseInfo.destination like :destination");
		}
		if (typeName != null && !"".equals(typeName)) {
			jpql.append("and ssr.routeBaseInfo.routeTypeList.typeName like :typeName");
		}
		if (startDays != null) {
			jpql.append("and size(ssr.routeTripList) >= :startDays");
		}
		if (endDays != null) {
			jpql.append("and size(ssr.routeTripList) <= :endDays");
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
	
//	public Page<SelfSupportRoute> findByRouteBaseInfoRouteNameOrRouteBaseInfoOutPlaceOrRouteBaseInfoDestinationOrRouteBaseInfoRouteTypeListTypeName(
//			String routeName, String outPlace, String destination, String typeName, Pageable pageable) {
//		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//		CriteriaQuery<SelfSupportRoute> criteriaQuery = criteriaBuilder.createQuery(SelfSupportRoute.class);
//		Root<SelfSupportRoute> root = criteriaQuery.from(SelfSupportRoute.class);
//		criteriaQuery.select(root);
//		Predicate restrictions = criteriaBuilder.conjunction();
//		if (routeName != null && !"".equals(routeName)) {
//			restrictions = criteriaBuilder.and(restrictions,
//					criteriaBuilder.like(root.get("routeBaseInfo").get("routeName"), "%"+routeName+"%"));
//		}
//		if (outPlace != null && !"".equals(outPlace)) {
//			restrictions = criteriaBuilder.and(restrictions,
//					criteriaBuilder.like(root.get("routeBaseInfo").get("outPlace"), "%"+outPlace+"%"));
//		}
//		if (destination != null && !"".equals(destination)) {
//			restrictions = criteriaBuilder.and(restrictions,
//					criteriaBuilder.like(root.get("routeBaseInfo").get("destination"), "%"+destination+"%"));
//		}
//		if (typeName != null && !"".equals(typeName)) {
//			restrictions = criteriaBuilder.and(restrictions,
//					criteriaBuilder.like(root.get("routeBaseInfo").get("routeTypeList").get("typeName"), "%"+typeName+"%"));
//		}
//		criteriaQuery.where(restrictions);
//		TypedQuery<SelfSupportRoute> tq = em.createQuery(criteriaQuery);
//		long total = tq.getResultList().size();
//		tq.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
//		tq.setMaxResults(pageable.getPageSize());
//		Page<SelfSupportRoute> page = new PageImpl<SelfSupportRoute>(tq.getResultList(), pageable, total);
//		return page;
//	}
	
}
