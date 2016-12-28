package org.honor.tourism.service;

import java.util.List;

import org.honor.tourism.entity.InsuranceManagement;
import org.honor.tourism.entity.InsuranceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 保险管理Service
 *
 */
public interface InsuranceManagementService {
	
	//保险查询
	public Page<InsuranceManagement> findAll(Pageable pageable);
	//数量
	public Long count();
	//新增/修改
	public InsuranceManagement save(InsuranceManagement insuranceManagement);
	//删除
	public void delete(String id);
	//获取单条数据
	public List<InsuranceManagement> findOne(String id);
}
