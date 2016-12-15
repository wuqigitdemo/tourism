package org.honor.tourism.entity;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * 线路类别
 */
@Entity
@Table(name = "t_route_category")
public class RouteCategory {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Length(min = 32, max = 32, message = "id需要32位字符")
	private String id;

	/** 类别名称 */
	@Length(min = 1, max = 30, message = "线路类别名称需要1-30位字符")
	private String categoryName;

	/** 产品类型 */
	@OneToMany
	private List<RouteType> routeTypeList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<RouteType> getRouteTypeList() {
		return routeTypeList;
	}

	public void setRouteTypeList(List<RouteType> routeTypeList) {
		this.routeTypeList = routeTypeList;
	}

}