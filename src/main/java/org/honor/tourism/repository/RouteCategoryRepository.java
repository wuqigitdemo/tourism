package org.honor.tourism.repository;

import org.honor.tourism.entity.RouteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 线路类别Repository
 *
 */
public interface RouteCategoryRepository extends JpaRepository<RouteCategory, String> {

}
