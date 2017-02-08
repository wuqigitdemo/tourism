package org.honor.tourism.repository;

import org.honor.tourism.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 部门Repository
 *
 */
public interface DepartmentRepository extends JpaRepository<Department, String> {

}
