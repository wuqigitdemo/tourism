package org.honor.tourism.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	/** 自营线路编号 */
	private String numbering;
	/** 经营类型 */
	private BusinessType businessType;
	@OneToOne(cascade = { CascadeType.ALL })
	private RouteBaseInfo routeBaseInfo;
	@OneToMany(cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
	@JoinColumn(name="selfSupportRouteId")
	private List<RouteTrip> routeTripList;
	@OneToMany(cascade = { CascadeType.ALL })
	private List<PriceInventory> priceInventory;
	@OneToOne(cascade = { CascadeType.ALL })
	private SelfSupportRouteOtherInfo selfSupportRouteOtherInfo;
	@ManyToMany
	private List<InsuranceManagement> insuranceManagementList;
	/** 创建日期 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
	/** 更新日期 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateDate;

	/**
	 * 经营类型
	 * 
	 * @author keiwu
	 *
	 */
	public enum BusinessType {
		SELF_EMPLOYED // 自营
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RouteBaseInfo getRouteBaseInfo() {
		return routeBaseInfo;
	}

	public void setRouteBaseInfo(RouteBaseInfo routeBaseInfo) {
		this.routeBaseInfo = routeBaseInfo;
	}

	public List<RouteTrip> getRouteTripList() {
		return routeTripList;
	}

	public void setRouteTripList(List<RouteTrip> routeTripList) {
		this.routeTripList = routeTripList;
	}

	public List<PriceInventory> getPriceInventory() {
		return priceInventory;
	}

	public void setPriceInventory(List<PriceInventory> priceInventory) {
		this.priceInventory = priceInventory;
	}

	public SelfSupportRouteOtherInfo getSelfSupportRouteOtherInfo() {
		return selfSupportRouteOtherInfo;
	}

	public void setSelfSupportRouteOtherInfo(SelfSupportRouteOtherInfo selfSupportRouteOtherInfo) {
		this.selfSupportRouteOtherInfo = selfSupportRouteOtherInfo;
	}

	public List<InsuranceManagement> getInsuranceManagementList() {
		return insuranceManagementList;
	}

	public void setInsuranceManagementList(List<InsuranceManagement> insuranceManagementList) {
		this.insuranceManagementList = insuranceManagementList;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getNumbering() {
		return numbering;
	}

	public void setNumbering(String numbering) {
		this.numbering = numbering;
	}

	public BusinessType getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}

}