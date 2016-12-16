package org.honor.tourism.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * 线路类别
 */
@Entity
@Table(name = "t_route_type")
public class RouteType {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Length(min = 32, max = 32, message = "id需要32位字符")
	private String id;
	/** 类别名称 */
	@Length(min = 1, max = 30, message = "线路类别名称需要1-30位字符")
	private String typeName;
	/** 父级 */
	@ManyToOne
	private RouteType routeType;
	@ManyToOne
	private RouteCategory routeCategory;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public RouteType getRouteType() {
		return routeType;
	}

	public void setRouteType(RouteType routeType) {
		this.routeType = routeType;
	}

	public RouteCategory getRouteCategory() {
		return routeCategory;
	}

	public void setRouteCategory(RouteCategory routeCategory) {
		this.routeCategory = routeCategory;
	}
}