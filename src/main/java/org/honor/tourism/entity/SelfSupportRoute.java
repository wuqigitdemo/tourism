package org.honor.tourism.entity;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 自营线路
 */
@Entity
@Table(name = "t_self_support_route")
public class SelfSupportRoute {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Length(min = 32, max = 32, message = "id需要32位字符")
	private String id;
	@OneToMany
	private List<RouteType> routeTypeList;
	@OneToOne
	private RouteBaseInfo routeBaseInfo;
	@OneToMany
	private List<RouteTrip> routeTripList;
	/**创建日期*/
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date createDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<RouteType> getRouteTypeList() {
		return routeTypeList;
	}

	public void setRouteTypeList(List<RouteType> routeTypeList) {
		this.routeTypeList = routeTypeList;
	}

	public RouteBaseInfo getRouteBaseInfo() {
		return routeBaseInfo;
	}

	public void setRouteBaseInfo(RouteBaseInfo routeBaseInfo) {
		this.routeBaseInfo = routeBaseInfo;
	}

}