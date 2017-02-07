package org.honor.tourism.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * 城市
 * 
 * @author keiwu
 *
 */
@Entity
@Table(name = "t_city")
public class City {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;
	/** 城市名称 */
	@Length(min = 2, max = 30, message = "城市名称需要2-30位字符")
	private String cityName;
	/** 父级城市 */
	@ManyToOne
	private City parentCity;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public City getParentCity() {
		return parentCity;
	}

	public void setParentCity(City parentCity) {
		this.parentCity = parentCity;
	}

}
