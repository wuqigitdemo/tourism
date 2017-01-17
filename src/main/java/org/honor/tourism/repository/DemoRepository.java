package org.honor.tourism.repository;

import java.util.List;

import org.honor.tourism.entity.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface DemoRepository extends JpaRepository< Demo, String> {

	public void deleteByDemoName(String demoName);
	
	public void saveEm(Demo demo);
	
	public void deleteEm(String id);
	
	public void deleteByDemoNameEm(String id);
	
	public void updateEm(String id);
	
	public Demo findByIdEm(String id);
	
	@Modifying
	@Transactional
	@Query(value = "delete from Demo s where s.id = ?1")
	public void deleteQuery(String id);

	@Modifying
	@Query(value = "update Demo d set d.demoName = ?1 where d.id = ?2")
	public void updateQuery(String name, String id);

	@Query(value = "select d from Demo d join d.demoChildrenList dc where dc.demoChildrenName = ?1")
	public List<Demo> findQuery(String name);
	
	public int deleteByDemoChildrenListDemoChildrenName(String name);
	
}
