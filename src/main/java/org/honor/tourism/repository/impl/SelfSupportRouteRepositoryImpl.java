package org.honor.tourism.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.honor.tourism.entity.SelfSupportRoute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class SelfSupportRouteRepositoryImpl {

	@PersistenceContext
	private EntityManager em;

	public List<SelfSupportRoute> findByRouteBaseInfoRouteNameOrRouteBaseInfoOutPlaceOrRouteBaseInfoDestinationOrRouteBaseInfoRouteTypeListTypeName(
			String routeName, String outPlace, String destination, String typeName, Pageable pageable) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<SelfSupportRoute> criteriaQuery = criteriaBuilder.createQuery(SelfSupportRoute.class);
		Root<SelfSupportRoute> root = criteriaQuery.from(SelfSupportRoute.class);
		criteriaQuery.select(root);
		Predicate restrictions = criteriaBuilder.conjunction();
		if (routeName != null && !"".equals(routeName)) {
			restrictions = criteriaBuilder.and(restrictions,
					criteriaBuilder.equal(root.get("routeBaseInfo").get("routeName"), routeName));
		}
		criteriaQuery.where(restrictions);
		TypedQuery<SelfSupportRoute> tq = em.createQuery(criteriaQuery);
		tq.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		tq.setMaxResults(pageable.getPageSize());
		return tq.getResultList();
	}

}
