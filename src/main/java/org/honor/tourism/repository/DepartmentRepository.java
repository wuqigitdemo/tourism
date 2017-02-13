package org.honor.tourism.repository;

import java.util.List;

import org.honor.tourism.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 部门Repository
 *
 */
public interface DepartmentRepository extends JpaRepository<Department, String> {

	/**
	 * 根据父级查询
	 * @return
	 */
	public List<Department> findByParentDepartmentId(String id);
	
	/**
	 * 根据条件查询部门
	 * @param departmentName
	 * @param parentDepartmentId
	 * @param delFlag
	 * @return
	 */
	public Page<Department> findDepts(String departmentName,String parentDepartmentId,String delFlag,Pageable pageable);
}
