package org.honor.tourism.service;

import java.util.List;

import org.honor.tourism.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *所在城市Service
 *
 */
public interface CityService {
	
	public Page<City> findAll(Pageable pageable);
	
	public Long count();
	
	public City save(City city);
	
	public void delete(String id);
	
	public List<City> findAll();

}
