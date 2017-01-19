package org.honor.tourism.repository;

import org.honor.tourism.entity.RouteTrip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 行程信息Repository
 *
 */

public interface RouteTripRepository extends JpaRepository<RouteTrip, String> {

	public Page<RouteTrip> findBySelfSupportRouteId(Pageable pageable, String selfSupportRouteId);
	
}
