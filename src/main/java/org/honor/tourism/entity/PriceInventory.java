package org.honor.tourism.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * 价格/库存
 * 
 * @author keiwu
 *
 */
@Entity
@Table(name = "t_price_inventory")
public class PriceInventory {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Length(min = 32, max = 32, message = "id需要32位字符")
	private String id;
	/** 库存日期 */
	@OneToMany
	private List<InventoryDate> inventoryDateList;
	/** 登记占位时限 */
	@Min(value = 0, message = "登记占位时限必须大于0")
	private Integer registrationTimeLimitPlaceholder;
	/** 保留位置 */
	@Min(value = 0, message = "保留位置必须大于0")
	private Integer reservedPosition;
	/** 单房差 */
	@Min(value = 0, message = "单房差必须大于0")
	private Double SingleRoomIsPoor;
	/**签证补价*/
	@Min(value = 0, message = "签证补价必须大于0")
	private Double aPremiumVisa;
	/**车队中心-分配单价*/
	@Min(value = 0, message = "车队中心-分配单价必须大于0")
	private Double fleetCenterAllocationUnitPrice;
	/**车队中心-分配总价*/
	@Min(value = 0, message = "车队中心-分配总价必须大于0")
	private Double fleetCenterAllocationTotalPrice;
	/**交通中心-分配单价*/
	@Min(value = 0, message = "交通中心-分配单价必须大于0")
	private Double trafficCenterAllocationUnitPrice;
	/**交通中心-分配总价*/
	@Min(value = 0, message = "交通中心-分配总价必须大于0")
	private Double trafficCenterAllocationTotalPrice;
	/**餐饮中心-分配单价*/
	@Min(value = 0, message = "餐饮中心-分配单价必须大于0")
	private Double cateringCenterAllocationUnitPrice;
	/**餐饮中心-分配总价*/
	@Min(value = 0, message = "餐饮中心-分配总价必须大于0")
	private Double cateringCenterAllocationTotalPrice;
	/**景区中心-分配单价*/
	@Min(value = 0, message = "景区中心-分配单价必须大于0")
	private Double scenicSpotCenterAllocationUnitPrice;
	/**景区中心-分配总价*/
	@Min(value = 0, message = "景区中心-分配总价必须大于0")
	private Double scenicSpotCenterAllocationTotalPrice;
	/**住房中心-分配单价*/
	@Min(value = 0, message = "住房中心-分配单价必须大于0")
	private Double housingSpotCenterAllocationUnitPrice;
	/**住房中心-分配总价*/
	@Min(value = 0, message = "住房中心-分配总价必须大于0")
	private Double housingSpotCenterAllocationTotalPrice;
	/**导游中心-分配单价*/
	@Min(value = 0, message = "住房中心-分配单价必须大于0")
	private Double tourGuideSpotCenterAllocationUnitPrice;
	/**住房中心-分配总价*/
	@Min(value = 0, message = "导游中心-分配总价必须大于0")
	private Double tourGuideSpotCenterAllocationTotalPrice;
	/**签证中心-分配单价*/
	@Min(value = 0, message = "签证中心-分配单价必须大于0")
	private Double visaCenterAllocationUnitPrice;
	/**签证中心-分配总价*/
	@Min(value = 0, message = "签证中心-分配总价必须大于0")
	private Double visaCenterAllocationTotalPrice;
	/**成人售价*/
	@Min(value = 0, message = "成人售价必须大于0")
	private Double adultPrice;
	/**折扣价*/
	@Min(value = 0, message = "折扣价必须大于0")
	private Double discountPrice;
	/**库存(人)*/
	@Min(value = 0, message = "库存必须大于0")
	private Integer inventoryPerson;
	/**儿童售价*/
	@Min(value = 0, message = "儿童售价必须大于0")
	private Double childrenPrice;
	/**儿童售价*/
	@Min(value = 0, message = "儿童售价必须大于0")
	private Double rriceFfBed;
	/**占床加价*/
	@Min(value = 0, message = "占床加价必须大于0")
	private Double priceOfBed;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<InventoryDate> getInventoryDateList() {
		return inventoryDateList;
	}

	public void setInventoryDateList(List<InventoryDate> inventoryDateList) {
		this.inventoryDateList = inventoryDateList;
	}

	public Integer getRegistrationTimeLimitPlaceholder() {
		return registrationTimeLimitPlaceholder;
	}

	public void setRegistrationTimeLimitPlaceholder(Integer registrationTimeLimitPlaceholder) {
		this.registrationTimeLimitPlaceholder = registrationTimeLimitPlaceholder;
	}

	public Integer getReservedPosition() {
		return reservedPosition;
	}

	public void setReservedPosition(Integer reservedPosition) {
		this.reservedPosition = reservedPosition;
	}

	public Double getSingleRoomIsPoor() {
		return SingleRoomIsPoor;
	}

	public void setSingleRoomIsPoor(Double singleRoomIsPoor) {
		SingleRoomIsPoor = singleRoomIsPoor;
	}

}
