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
			String routeName, String outPlace, String destination, String typeName, Pageable pageable) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<SelfSupportRoute> criteriaQuery = criteriaBuilder.createQuery(SelfSupportRoute.class);
		Root<SelfSupportRoute> root = criteriaQuery.from(SelfSupportRoute.class);
		criteriaQuery.select(root);
		Predicate restrictions = criteriaBuilder.conjunction();
		if (routeName != null && !"".equals(routeName)) {
			restrictions = criteriaBuilder.and(restrictions,
					criteriaBuilder.like(root.get("routeBaseInfo").get("routeName"), "%"+routeName+"%"));
		}
		if (outPlace != null && !"".equals(outPlace)) {
			restrictions = criteriaBuilder.and(restrictions,
					criteriaBuilder.like(root.get("routeBaseInfo").get("outPlace"), "%"+outPlace+"%"));
		}
		if (destination != null && !"".equals(destination)) {
			restrictions = criteriaBuilder.and(restrictions,
					criteriaBuilder.like(root.get("routeBaseInfo").get("destination"), "%"+destination+"%"));
		}
		if (typeName != null && !"".equals(typeName)) {
			restrictions = criteriaBuilder.and(restrictions,
					criteriaBuilder.like(root.get("routeBaseInfo").get("routeTypeList").get("typeName"), "%"+typeName+"%"));
		}
		criteriaQuery.where(restrictions);
		TypedQuery<SelfSupportRoute> tq = em.createQuery(criteriaQuery);
		long total = tq.getResultList().size();
		tq.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		tq.setMaxResults(pageable.getPageSize());
		Page<SelfSupportRoute> page = new PageImpl<SelfSupportRoute>(tq.getResultList(), pageable, total);
		return page;
	}
}
