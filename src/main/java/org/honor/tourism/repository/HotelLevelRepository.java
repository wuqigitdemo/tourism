package org.honor.tourism.repository;

import org.honor.tourism.entity.HotelLevel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 酒店星级管理Repository
 *
 */
public interface HotelLevelRepository extends JpaRepository<HotelLevel, String> {

}
