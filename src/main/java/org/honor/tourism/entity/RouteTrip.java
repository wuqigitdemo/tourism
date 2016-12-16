package org.honor.tourism.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * 行程表
 * 
 * @author keiwu
 *
 */
@Entity
@Table(name = "t_route_trip")
public class RouteTrip {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Length(min = 32, max = 32, message = "id需要32位字符")
	private String id;
	/** 行程标题 */
	@Length(min = 1, max = 50, message = "行程标题需要1-50位字符")
	private String tripTitle;
	/** 行程详细 */
	@Length(min = 1, max = 50, message = "行程详细需要1-50位字符")
	private String tripDetail;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTripTitle() {
		return tripTitle;
	}

	public void setTripTitle(String tripTitle) {
		this.tripTitle = tripTitle;
	}

	public String getTripDetail() {
		return tripDetail;
	}

	public void setTripDetail(String tripDetail) {
		this.tripDetail = tripDetail;
	}

}
