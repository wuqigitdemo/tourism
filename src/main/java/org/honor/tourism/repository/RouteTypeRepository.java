package org.honor.tourism.repository;

import java.util.List;

import org.honor.tourism.entity.RouteType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 线路类别Repository
 * @author keiwu
 *
 */
public interface RouteTypeRepository extends JpaRepository<RouteType, String> {

	public List<RouteType> findByRouteCategoryId(String routeCategoryId);
	
}
