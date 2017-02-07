package org.honor.tourism.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * 酒店提供的服务
 * 
 * @author keiwu
 *
 */
@Entity
@Table(name = "t_hotel_provide_service")
public class HotelProvideService {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;
	/** 服务名称 */
	@Length(min = 1, max = 30, message = "服务名称需要2-30位字符")
	private String serviceName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

}
