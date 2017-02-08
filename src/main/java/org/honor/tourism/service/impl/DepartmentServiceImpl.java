package org.honor.tourism.service.impl;

import java.util.List;

import org.honor.tourism.entity.Department;
import org.honor.tourism.entity.RouteType;
import org.honor.tourism.repository.DepartmentRepository;
import org.honor.tourism.repository.RouteTypeRepository;
import org.honor.tourism.service.DepartmentService;
import org.honor.tourism.service.RouteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mysql.fabric.Response;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository repository;

	@Override
	public Page<Department> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public List<Department> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public Department save(Department department) {
		return repository.save(department);
	}

	@Override
	public void delete(String id) {
		repository.delete(id);
	}

	@Override
	public Department getOne(String id){
		return repository.getOne(id);
	}

}
