package org.honor.tourism.repository;

import org.honor.tourism.entity.RouteDay;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 日程信息repository
 * @author 刘海
 *
 */
public interface RouteDayRepository extends JpaRepository<RouteDay, String> {

}
