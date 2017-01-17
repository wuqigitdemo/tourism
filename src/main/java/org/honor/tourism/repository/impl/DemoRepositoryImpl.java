package org.honor.tourism.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.honor.tourism.entity.Demo;

public class DemoRepositoryImpl {

	@PersistenceContext
	private EntityManager em;
	
	public void saveEm(Demo demo) {
		em.persist(demo);
	}
	
	public void deleteEm(String id) {
		Demo demo = em.find(Demo.class, id);
		System.out.println("demoid:" + demo);
		em.remove(demo);
	}
	
	public void updateEm(String id) {
		Demo demoR = em.find(Demo.class, id);
		System.out.println("demoid:" + demoR);
		demoR.setDemoName("修改名称");
	}
	
	public Demo findByIdEm(String id) {
		return em.find(Demo.class, id);
	}
	
	public void deleteByDemoNameEm(String id) {
		System.out.println("删除的id: " + id);
		Query query = em.createQuery("delete from Demo s where s.id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
	
}
