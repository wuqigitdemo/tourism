package org.honor.tourism.service;

import java.util.List;

import org.honor.tourism.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 部门Service
 *
 */
public interface DepartmentService {

	public Page<Department> findAll(Pageable pageable);
	
	public Long count();
	
	public Department save(Department department);
	
	public void delete(String id);

	public List<Department> findAll();
	
	public Department getOne(String id);
	
}
