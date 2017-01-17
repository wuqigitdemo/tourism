package org.honor.tourism.service;

import java.util.List;

import org.honor.tourism.entity.Demo;

public interface DemoService extends CrudService<Demo> {

	public void deleteByDemoName(String demoName);
	
	public void saveEm(Demo demo);
	
	public void deleteEm(String id);
	
	public void updateEm(String id);
	
	public Demo findByIdEm(String id);
	
	public void deleteQuery(String id);
	
	public void updateQuery(String name, String id);
	
	public List<Demo> findQuery(String name);
	
	public void deleteByDemoChildrenListDemoChildrenName(String name);
	
	public void deleteByDemoNameEm(String id);
	
}
