package org.honor.tourism.repository;

import java.util.List;

import org.honor.tourism.entity.SelfSupportRoute;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelfSupportRouteRepository extends JpaRepository<SelfSupportRoute, String> {
	
	public List<SelfSupportRoute> findByRouteBaseInfoRouteNameOrRouteBaseInfoOutPlaceOrRouteBaseInfoDestinationOrRouteBaseInfoRouteTypeListTypeName(String routeName, String outPlace, String destination, String typeName, Pageable pageable);
	
}
