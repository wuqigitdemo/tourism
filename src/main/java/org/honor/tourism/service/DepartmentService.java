package org.honor.tourism.service;

import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.Department;
import org.honor.tourism.entity.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 部门Service
 *
 */
public interface DepartmentService extends CrudService<Department> {

	public Page<Department> findAll(Pageable pageable);
	
	public Long count();
	
	public Department save(Department department);
	
	public void delete(String id);

	public List<Department> findAll();
	
	public Department getOne(String id);
	
	public Department findOne(String id);
	
	/**
	 * 查找子节点
	 * @param department
	 * @return
	 */
	public List<Map<String,Object>> findChildren(Department department);
	
	/**
	 * 查找后代节点的员工
	 * @param department
	 * @return
	 */
	public List<SysUser> findUsers(Department department);
	
	/**
	 * 根据条件查询部门,返回tree
	 * @param departmentName
	 * @param parentDepartmentId
	 * @param delFlag
	 * @return
	 */
	public Page<Department> findDepts(String departmentName,String parentDepartmentId,String delFlag,Pageable pageable);
	
	/**
	 * 查询子部门
	 * @param parentDepartmentId
	 * @param pageable
	 * @return
	 */
	public Page<Department> findByParentDepartmentId(String parentDepartmentId,Pageable pageable);
	
	/**
	 * 批量删除部门
	 * @param userIds
	 * @return
	 */
	public void deleteDepts(List<String> deptIds);
}
