package org.honor.tourism.repository;

import org.honor.tourism.entity.RouteBaseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 自营线路信息Repository
 */
public interface RouteBaseInfoRepository extends JpaRepository<RouteBaseInfo, String> {

}
