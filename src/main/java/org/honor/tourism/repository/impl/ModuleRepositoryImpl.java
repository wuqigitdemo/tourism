package org.honor.tourism.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.honor.tourism.entity.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 * 作者:修罗大人
 * 日期:Feb 17, 2017
 * 时间:3:25:51 PM
 */

public class ModuleRepositoryImpl {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 根据条件查询模块
	 * @param moduleName
	 * @param parentModuleId
	 * @return
	 */
	public Page<Module> findModules(String moduleName,String parentModuleId, Pageable pageable)
	{
		StringBuffer sb  = new StringBuffer();
		sb.append("from Module m ");
		sb.append("where 1=1");
		
		if (moduleName != null && !moduleName.equals("")) {
			sb.append(" and m.moduleName like :moduleName");
		}
		
		if (parentModuleId != null && !parentModuleId.equals("")) {
			sb.append(" and m.parentModule.id like :parentModuleId");
		}
		
		TypedQuery<Module> tq = em.createQuery(sb.toString(), Module.class);
		if (moduleName != null && !moduleName.equals("")) {
			tq.setParameter("moduleName", "%"+moduleName+"%");
		}
		if (parentModuleId != null && !parentModuleId.equals("")) {
			tq.setParameter("parentModuleId", "%"+parentModuleId+"%");
		}
		
		long total = tq.getResultList().size();
		tq.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		tq.setMaxResults(pageable.getPageSize());
		Page<Module> page = new PageImpl<Module>(tq.getResultList(), pageable, total);
		
		return page;
	}
	
}
