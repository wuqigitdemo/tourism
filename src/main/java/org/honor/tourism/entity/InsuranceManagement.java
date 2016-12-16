package org.honor.tourism.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * 保险管理
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_insurance_management")
public class InsuranceManagement {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Length(min = 32, max = 32, message = "id需要32位字符")
	private String id;
	/** 险种 */
	@Length(min = 1, max = 30, message = "险种需要1-30位字符")
	private String insuranceType;
	/** 保险名称 */
	@Length(min = 1, max = 30, message = "保险名称需要1-30位字符")
	private String insuranceName;
	/** 成本 */
	@DecimalMin(value = "0", message = "成本不能小于0")
	private Double cost;
	/** 售价 */
	@DecimalMin(value = "0", message = "售价不能小于0")
	private Double price;
	/** 保险说明 */
	@Length(min = 1, max = 100, message = "保险说明需要1-100位字符")
	private String insuranceInstructions;
	/** 保险期限 */
	@Length(min = 1, max = 10, message = "保险期限需要1-10位字符")
	private String insurancePeriod;
	/** 保险内容 */
	@Length(min = 1, max = 500, message = "保险期限需要1-500位字符")
	private String insuranceContent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getInsuranceInstructions() {
		return insuranceInstructions;
	}

	public void setInsuranceInstructions(String insuranceInstructions) {
		this.insuranceInstructions = insuranceInstructions;
	}

	public String getInsurancePeriod() {
		return insurancePeriod;
	}

	public void setInsurancePeriod(String insurancePeriod) {
		this.insurancePeriod = insurancePeriod;
	}

	public String getInsuranceContent() {
		return insuranceContent;
	}

	public void setInsuranceContent(String insuranceContent) {
		this.insuranceContent = insuranceContent;
	}

}
