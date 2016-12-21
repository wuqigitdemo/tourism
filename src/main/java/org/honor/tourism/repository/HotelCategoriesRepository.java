package org.honor.tourism.repository;

import org.honor.tourism.entity.HotelCategories;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 酒店管理Repository
 * @author keiwu
 *
 */
public interface HotelCategoriesRepository extends JpaRepository<HotelCategories, String> {

	@Override
	default void delete(String id) {
		System.out.println(id);
	}
}
