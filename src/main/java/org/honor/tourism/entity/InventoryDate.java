package org.honor.tourism.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 库存日期
 * 
 * @author keiwu
 *
 */
@Entity
@Table(name = "t_inventory_date")
public class InventoryDate {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Length(min = 32, max = 32, message = "id需要32位字符")
	private String id;
	/** 库存日期 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date inventoryDate;
	/** 成人售价 */
	@Min(value = 0, message = "成人售价必须大于0")
	private Double adultPrice;
	/** 折扣价 */
	@Min(value = 0, message = "折扣价必须大于0")
	private Double discountPrice;
	/** 儿童售价 */
	@Min(value = 0, message = "儿童售价必须大于0")
	private Double childrenPrice;
	/** 儿童折扣价 */
	@Min(value = 0, message = "儿童折扣价必须大于0")
	private Double childrenDiscountPrice;
	/** 库存(人) */
	@Min(value = 0, message = "库存必须大于0")
	private Integer inventoryPerson;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getInventoryDate() {
		return inventoryDate;
	}

	public void setInventoryDate(Date inventoryDate) {
		this.inventoryDate = inventoryDate;
	}

	public Double getAdultPrice() {
		return adultPrice;
	}

	public void setAdultPrice(Double adultPrice) {
		this.adultPrice = adultPrice;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Double getChildrenPrice() {
		return childrenPrice;
	}

	public void setChildrenPrice(Double childrenPrice) {
		this.childrenPrice = childrenPrice;
	}

	public Double getChildrenDiscountPrice() {
		return childrenDiscountPrice;
	}

	public void setChildrenDiscountPrice(Double childrenDiscountPrice) {
		this.childrenDiscountPrice = childrenDiscountPrice;
	}

	public Integer getInventoryPerson() {
		return inventoryPerson;
	}

	public void setInventoryPerson(Integer inventoryPerson) {
		this.inventoryPerson = inventoryPerson;
	}

}
