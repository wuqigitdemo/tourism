package org.honor.tourism.repository;

import org.honor.tourism.entity.DemoChildren;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface DemoChildrenRepository extends JpaRepository< DemoChildren, String> {

	@Modifying
	@Transactional
	@Query(value = "delete from DemoChildren s where s.id = ?1")
	public void deleteQuery(String id);
	
}
