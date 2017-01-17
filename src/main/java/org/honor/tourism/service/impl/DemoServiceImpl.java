package org.honor.tourism.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.honor.tourism.entity.Demo;
import org.honor.tourism.repository.DemoRepository;
import org.honor.tourism.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl extends CrudServiceImpl<Demo> implements DemoService {
	
	@Autowired
	private DemoRepository repository;

	@Autowired
	public DemoServiceImpl(JpaRepository<Demo, String> repository) {
		super(repository);
	}
	
	@Transactional
	public void deleteByDemoName(String demoName) {
		repository.deleteByDemoName(demoName);
	}
	
	@Transactional
	public void saveEm(Demo demo) {
		repository.saveEm(demo);
	}
	
	@Transactional
	public void deleteEm(String id) {
		repository.deleteEm(id);
	}
	
	@Transactional
	public void updateEm(String id) {
		repository.updateEm(id);
	}
	
	public Demo findByIdEm(String id) {
		return repository.findByIdEm(id);
	}
	
	@Transactional
	public void deleteQuery(String id) {
		repository.deleteQuery(id);
	}
	
	@Transactional
	public void updateQuery(String name, String id) {
		repository.updateQuery(name, id);
	}
	
	public List<Demo> findQuery(String name) {
		return repository.findQuery(name);
	}
	
	@Transactional
	public void deleteByDemoChildrenListDemoChildrenName(String name) {
		repository.deleteByDemoChildrenListDemoChildrenName(name);
	}
	
	@Transactional
	public void deleteByDemoNameEm(String id) {
		repository.deleteByDemoNameEm(id);
	}

}
