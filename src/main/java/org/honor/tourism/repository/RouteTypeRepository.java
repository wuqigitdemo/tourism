package org.honor.tourism.repository;

import org.honor.tourism.entity.RouteType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 线路类别Repository
 * @author keiwu
 *
 */
public interface RouteTypeRepository extends JpaRepository<RouteType, String> {

}
