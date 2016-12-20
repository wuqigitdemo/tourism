package org.honor.tourism.service;

import org.honor.tourism.entity.SelfSupportRouteOtherInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 自营路线其他信息
 * @author 刘海
 *
 */
public interface SelfSupportRouteOtherInfoService {
	
	public Page<SelfSupportRouteOtherInfo> findAll(Pageable pageable);
	
	public Long count();
	
	public SelfSupportRouteOtherInfo save(SelfSupportRouteOtherInfo selfSupportRouteOtherInfo);
	
	public void delete(String id);

}
