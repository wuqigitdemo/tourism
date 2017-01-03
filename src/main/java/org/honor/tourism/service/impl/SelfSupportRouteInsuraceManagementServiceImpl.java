package org.honor.tourism.service.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.honor.tourism.entity.InsuranceManagement;
import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.repository.InsuranceManagementRepository;
import org.honor.tourism.repository.SelfSupportRouteRepository;
import org.honor.tourism.service.SelfSupportRouteInsuraceManagementService;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者:修罗大人
 * 日期:Jan 3, 2017
 * 时间:2:51:33 PM
 * 自营线路保险管理ServiceImpl
 */
@Service
public class SelfSupportRouteInsuraceManagementServiceImpl implements SelfSupportRouteInsuraceManagementService{

	@Autowired
	public InsuranceManagementRepository insuranceManagementRepository;
	
	@Autowired
	public SelfSupportRouteRepository selfSupportRouteRepository;
	
	/**
	 * 添加保险
	 * @param imId
	 * @param routeId
	 * @return
	 */
	@Override
	@Transactional
	public Map<String, Object> addInsuranceManagement(String imId,String routeId) {
		
		//查询保险
		InsuranceManagement insuranceManagement = insuranceManagementRepository.getOne(imId);
		
		//查询线路
		SelfSupportRoute selfSupportRoute = selfSupportRouteRepository.getOne(routeId);
		
		//线路保险列表
		List<InsuranceManagement> insuranceManagementList = selfSupportRoute.getInsuranceManagementList();
		
		boolean isHave = false;
		for (InsuranceManagement im : insuranceManagementList) 
		{
			if (im.getId().equals(insuranceManagement.getId())) 
			{
				isHave = true;
				break;
			}
		}
		
		if (!isHave) 
		{
			insuranceManagementList.add(insuranceManagement);
		}else{
			return EasyuiResult.result(true,"保险已存在");
		}
		
		try {
			selfSupportRouteRepository.save(selfSupportRoute);
		} catch (Exception e) {
			e.printStackTrace();
			return EasyuiResult.result(false,"操作失败");
		}
		
		return EasyuiResult.result(true,"操作成功");
	}
}
