package org.honor.tourism.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * 线路类型
 */
@Entity
@Table(name = "t_route_type")
public class RouteType {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Length(min = 32, max = 32, message = "id需要32位字符")
	private String id;
	/** 类型名称 */
	@Length(min = 1, max = 30, message = "线路类型名称需要1-30位字符")
	private String typeName;
	/** 父类id */
	@Length(min = 32, max = 32, message = "父类id需要32位字符")
	private String parentId;
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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public RouteCategory getRouteCategory() {
		return routeCategory;
	}

	public void setRouteCategory(RouteCategory routeCategory) {
		this.routeCategory = routeCategory;
	}

}