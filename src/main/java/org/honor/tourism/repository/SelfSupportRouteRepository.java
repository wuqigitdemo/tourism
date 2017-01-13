package org.honor.tourism.repository;

import org.honor.tourism.entity.SelfSupportRoute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface SelfSupportRouteRepository extends JpaRepository<SelfSupportRoute, String> {
	
	public Page<SelfSupportRoute> findByRouteBaseInfoRouteNameOrRouteBaseInfoOutPlaceOrRouteBaseInfoDestinationOrRouteBaseInfoRouteTypeListTypeName(String routeName, String outPlace, String destination, String typeName, Integer startDays, Integer endDays, Pageable pageable);
	
	public SelfSupportRoute findByRouteBaseInfoRouteName(String routeName);
	 
	@Modifying(clearAutomatically = true)
	@Query(value = "update SelfSupportRoute s set s.numbering = ?1 where s.id = ?2")
	public int deleteBy(String routeName, String bh);
	
}
