package org.honor.tourism.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * 保险管理
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
	
	/** 价格 */
	@Length(min = 3, max = 10, message = "价格需要3-10位字符")
	private String price;
	
	/** 保险说明 */
	@Length(min = 1, max = 100, message = "保险说明需要1-100位字符")
	private String insuranceInstructions;
	
	/** 保险期限 */
	@Length(min = 1, max = 10, message = "保险期限需要1-10位字符")
	private String insurancePeriod;

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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
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
	
}
