package org.honor.tourism.service.impl;

import java.util.Map;

import javax.transaction.Transactional;

import org.honor.tourism.entity.SelfSupportRoute;
import org.honor.tourism.entity.SelfSupportRouteOtherInfo;
import org.honor.tourism.repository.SelfSupportRouteOtherInfoRepository;
import org.honor.tourism.repository.SelfSupportRouteRepository;
import org.honor.tourism.service.SelfSupportRouteOtherInfoService;
import org.honor.tourism.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * 作者:修罗大人
 * 日期:Dec 28, 2016
 * 时间:10:37:43 AM
 * 其他信息serviceImpl
 */

@Service
public class SelfSupportRouteOtherInfoServiceImpl extends CrudServiceImpl<SelfSupportRouteOtherInfo> implements SelfSupportRouteOtherInfoService {

	@Autowired
	private SelfSupportRouteOtherInfoRepository selfSupportRouteOtherInfoRepository;
	
	@Autowired
	private SelfSupportRouteRepository selfSupportRouteRepository;
	
	@Autowired
	public SelfSupportRouteOtherInfoServiceImpl(JpaRepository<SelfSupportRouteOtherInfo, String> repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 保存其他信息
	 * @param selfSupportRouteOtherInfo
	 * @param routeId
	 * @return
	 */
	@Override
	@Transactional
	public Map<String, Object> saveOtherInfo(SelfSupportRouteOtherInfo selfSupportRouteOtherInfo, String routeId) {

		//保存线路其他信息
		selfSupportRouteOtherInfoRepository.save(selfSupportRouteOtherInfo);
		
		//将其他信息保存到线路
		SelfSupportRoute selfSupportRoute = selfSupportRouteRepository.getOne(routeId);
		selfSupportRoute.setSelfSupportRouteOtherInfo(selfSupportRouteOtherInfo);
		selfSupportRouteRepository.save(selfSupportRoute);
		
		return EasyuiResult.result(true, "操作成功");
	}
}
