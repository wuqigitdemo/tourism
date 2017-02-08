package org.honor.tourism.repository;

import org.honor.tourism.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 所在城市Repository
 *
 */
public interface CityRepository  extends JpaRepository<City, String>{

}
