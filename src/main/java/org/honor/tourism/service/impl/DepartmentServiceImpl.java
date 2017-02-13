package org.honor.tourism.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.honor.tourism.entity.Department;
import org.honor.tourism.entity.SysUser;
import org.honor.tourism.repository.DepartmentRepository;
import org.honor.tourism.repository.SysUserRepository;
import org.honor.tourism.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends CrudServiceImpl<Department> implements DepartmentService {
	
	@Autowired
	public DepartmentServiceImpl(JpaRepository<Department, String> repository) {
		super(repository);
		this.users = new ArrayList<SysUser>();
	}

	@Autowired
	private DepartmentRepository repository;
	
	@Autowired
	private SysUserRepository sysUserRepository;

	private List<SysUser> users;
	
	/**
	 * 查找子节点
	 * @param department
	 * @return List<Map<String,Object>>
	 */
	public List<Map<String,Object>> findChildren(Department department) {
		
		List<Map<String,Object>> retDepts = new ArrayList<Map<String,Object>>();
		List<Department> departments = new ArrayList<>();
				
		//根节点
		if (department == null) {
			departments = repository.findByParentDepartmentId(null);
		}else {
			departments = repository.findByParentDepartmentId(department.getId());
		}
		
		if (departments.size() != 0) 
		{
			for (Department departmentTemp : departments) {
				Map<String, Object> deptMap = new HashMap<>();
				deptMap.put("id", departmentTemp.getId());
				deptMap.put("departmentName", departmentTemp.getDepartmentName());
				
				List<Map<String, Object>> children = findChildren(departmentTemp);
				if (children.size() != 0) {
					//deptMap.put("children", children);
					deptMap.put("state","closed");
				}
				
				retDepts.add(deptMap);
			}
		}
		
		return retDepts;
	}
	
	/**
	 * 查找后代节点的员工,返回tree
	 * @param department
	 * @return List<Map<String,Object>>
	 */
	public List<Map<String,Object>> findProgenyUsers(Department department) {
		
		List<Map<String,Object>> retDepts = new ArrayList<Map<String,Object>>();
		List<Department> departments = new ArrayList<>();
				
		//根节点
		if (department == null) {
			departments = repository.findByParentDepartmentId(null);
		}else {
			departments = repository.findByParentDepartmentId(department.getId());
		}
		
		if (departments.size() != 0) 
		{
			for (Department departmentTemp : departments) {
				Map<String, Object> deptMap = new HashMap<>();
				deptMap.put("id", departmentTemp.getId());
				deptMap.put("departmentName", departmentTemp.getDepartmentName());
				
				List<Map<String, Object>> children = findChildren(departmentTemp);
				if (children.size() != 0) {
					deptMap.put("children", children);
					deptMap.put("state","closed");
				}
				
				List<SysUser> users = sysUserRepository.findByDepartmentId(departmentTemp.getId());

				for (SysUser sysUser : users) {
					this.users.add(sysUser);
				}
				
				deptMap.put("users", users);
				retDepts.add(deptMap);
			}
		}else {
			List<SysUser> users = sysUserRepository.findByDepartmentId(department.getId());

			for (SysUser sysUser : users) {
				this.users.add(sysUser);
			}
		}
		
		return retDepts;
	}
	
	/**
	 * 查找后代节点的员工，返回list
	 * @param department
	 * @return List<Map<String,Object>>
	 */
	public List<SysUser> findUsers(Department department)	
	{
		this.users = new ArrayList<SysUser>();
		List<Map<String, Object>> depts = findProgenyUsers(department);
		return this.users;
	}
	
	/**
	 * 删除子节点
	 * @param department
	 * @return List<Map<String,Object>>
	 */
	public void deleteChildren(Department department) {

		List<Department> departments = new ArrayList<>();
				
		//根节点
		if (department == null) {
			departments = repository.findByParentDepartmentId(null);
		}else {
			departments = repository.findByParentDepartmentId(department.getId());
		}
		
		if (departments.size() != 0) 
		{
			for (Department departmentTemp : departments) 
			{
				deleteChildren(departmentTemp);
				repository.delete(departmentTemp);
			}
			repository.delete(department);
		}else {
			repository.delete(department);
		}
	}
	
	/**
	 * 根据条件查询部门
	 * @param departmentName
	 * @param parentDepartmentId
	 * @param delFlag
	 * @return
	 */
	public Page<Department> findDepts(String departmentName,String parentDepartmentId,String delFlag,Pageable pageable)
	{
		return repository.findDepts(departmentName, parentDepartmentId, delFlag,pageable);
	}
	
	/**
	 * 查询子部门
	 * @param parentDepartmentId
	 * @param pageable
	 * @return
	 */
	public Page<Department> findByParentDepartmentId(String parentDepartmentId,Pageable pageable)
	{
		List<Department> departments = repository.findByParentDepartmentId(parentDepartmentId);
		
		int startIndex = pageable.getPageNumber() * pageable.getPageSize();
		int pageSize = pageable.getPageSize();
		int total = departments.size();
		int endIndex = (startIndex + pageSize) > total ? total : (startIndex + pageSize);
		
		List<Department> departmentsTemp = new ArrayList<Department>();
		for (int i = startIndex; i < endIndex; i++) 
		{
			departmentsTemp.add(departments.get(i));
		}
		
		Page<Department> page = new PageImpl<Department>(departmentsTemp, pageable, total);
		
		return page;
	}
	
	/**
	 * 批量删除部门
	 * @param userIds
	 * @return
	 */
	public void deleteDepts(List<String> deptIds)
	{
		for (String id : deptIds) {
			
			Department department = repository.findOne(id);
			
			if (department != null) {
				deleteChildren(department);
			}
		}
	}

	@Override
	public List<Department> findAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department getOne(String id)
	{
		return repository.getOne(id);
	}

	@Override
	public Department findOne(String id)
	{
		return repository.findOne(id);
	}
}
