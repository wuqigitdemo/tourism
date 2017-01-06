package org.honor.tourism.service;

import java.util.List;

import org.honor.tourism.entity.DiningType;

/**
 * 用餐类型Service
 * @author 刘海
 *
 */
public interface DiningTypeService extends CrudService<DiningType> {
	
	public List<DiningType> findAll();

}
