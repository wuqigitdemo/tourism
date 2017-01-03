package org.honor.tourism.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
	@OneToMany(cascade={CascadeType.ALL})
	@NotNull(message = "库存日期不能为空")
	private List<InventoryDate> inventoryDateList;
	/** 登记占位时限 */
	@Min(value = 0, message = "登记占位时限必须大于0")
	@NotNull(message = "登记占位时限不能为空")
	private Integer registrationTimeLimitPlaceholder;
	/** 保留位置 */
	@Min(value = 0, message = "保留位置必须大于0")
	@NotNull(message = "保留位置不能为空")
	private Integer reservedPosition;
	/** 单房差 */
	@Min(value = 0, message = "单房差必须大于0")
	private Double SingleRoomIsPoor;
	/** 签证补价 */
	@Min(value = 0, message = "签证补价必须大于0")
	private Double aPremiumVisa;
	/** 车队中心-分配单价 */
	@Min(value = 0, message = "车队中心-分配单价必须大于0")
	private Double fleetCenterAllocationUnitPrice;
	/** 车队中心-分配总价 */
	@Min(value = 0, message = "车队中心-分配总价必须大于0")
	private Double fleetCenterAllocationTotalPrice;
	/** 交通中心-分配单价 */
	@Min(value = 0, message = "交通中心-分配单价必须大于0")
	private Double trafficCenterAllocationUnitPrice;
	/** 交通中心-分配总价 */
	@Min(value = 0, message = "交通中心-分配总价必须大于0")
	private Double trafficCenterAllocationTotalPrice;
	/** 餐饮中心-分配单价 */
	@Min(value = 0, message = "餐饮中心-分配单价必须大于0")
	private Double cateringCenterAllocationUnitPrice;
	/** 餐饮中心-分配总价 */
	@Min(value = 0, message = "餐饮中心-分配总价必须大于0")
	private Double cateringCenterAllocationTotalPrice;
	/** 景区中心-分配单价 */
	@Min(value = 0, message = "景区中心-分配单价必须大于0")
	private Double scenicSpotCenterAllocationUnitPrice;
	/** 景区中心-分配总价 */
	@Min(value = 0, message = "景区中心-分配总价必须大于0")
	private Double scenicSpotCenterAllocationTotalPrice;
	/** 住房中心-分配单价 */
	@Min(value = 0, message = "住房中心-分配单价必须大于0")
	private Double housingSpotCenterAllocationUnitPrice;
	/** 住房中心-分配总价 */
	@Min(value = 0, message = "住房中心-分配总价必须大于0")
	private Double housingSpotCenterAllocationTotalPrice;
	/** 导游中心-分配单价 */
	@Min(value = 0, message = "导游中心-分配单价必须大于0")
	private Double tourGuideSpotCenterAllocationUnitPrice;
	/** 导游中心-分配总价 */
	@Min(value = 0, message = "导游中心-分配总价必须大于0")
	private Double tourGuideSpotCenterAllocationTotalPrice;
	/** 签证中心-分配单价 */
	@Min(value = 0, message = "签证中心-分配单价必须大于0")
	private Double visaCenterAllocationUnitPrice;
	/** 签证中心-分配总价 */
	@Min(value = 0, message = "签证中心-分配总价必须大于0")
	private Double visaCenterAllocationTotalPrice;
	/** 成人售价 */
	@Min(value = 0, message = "成人售价必须大于0")
	private Double adultPrice;
	/** 折扣价 */
	@Min(value = 0, message = "折扣价必须大于0")
	private Double discountPrice;
	/** 库存(人) */
	@Min(value = 0, message = "库存必须大于0")
	private Integer inventoryPerson;
	/** 儿童售价 */
	@Min(value = 0, message = "儿童售价必须大于0")
	private Double childrenPrice;
	/** 儿童折扣价 */
	@Min(value = 0, message = "儿童折扣价必须大于0")
	private Double childrenDiscountPrice;
	/** 占床加价 */
	@Min(value = 0, message = "占床加价必须大于0")
	private Double priceOfBed;
	/** 儿童界定标准值 */
	@Min(value = 0, message = "儿童界定标准值 必须大于0")
	private Integer childrenDefineStandardValue;
	/** 儿童界定标准 */
	private ChildrenDefineStandard childrenDefineStandard;
	/** 特殊人群说明 */
	private String specialPopulationDescription;
	/** 儿童价格说明 */
	private String childrensPriceDescription;
	/** 同业成人售价 */
	@Min(value = 0, message = "同业成人售价必须大于0")
	private Double withTheIndustryAdultPrice;
	/** 同业折扣价 */
	@Min(value = 0, message = "同业折扣价必须大于0")
	private Double withTheIndustryDiscountPrice;
	/** 同业库存(人) */
	@Min(value = 0, message = "同业库存必须大于0")
	private Integer withTheIndustryInventoryPerson;
	/** 同业儿童售价 */
	@Min(value = 0, message = "同业儿童售价必须大于0")
	private Double withTheIndustryChildrenPrice;
	/** 同业儿童折扣价 */
	@Min(value = 0, message = "同业儿童折扣价必须大于0")
	private Double withTheIndustryChildrenDiscountPrice;
	/** 同业占床加价 */
	@Min(value = 0, message = "同业占床加价必须大于0")
	private Double withTheIndustryPriceOfBed;
	/** 同业儿童界定标准值 */
	@Min(value = 0, message = "同业儿童界定标准值 必须大于0")
	private Integer withTheIndustryChildrenDefineStandardValue;
	/** 同业儿童界定标准 */
	private ChildrenDefineStandard withTheIndustryChildrenDefineStandard;
	/** 同业特殊人群说明 */
	private String withTheIndustrySpecialPopulationDescription;
	/** 同业儿童价格说明 */
	private String withTheIndustryChildrensPriceDescription;

	public enum ChildrenDefineStandard {// 儿童界定标准
		AGE, HEIGHT
	}

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

	public Double getaPremiumVisa() {
		return aPremiumVisa;
	}

	public void setaPremiumVisa(Double aPremiumVisa) {
		this.aPremiumVisa = aPremiumVisa;
	}

	public Double getFleetCenterAllocationUnitPrice() {
		return fleetCenterAllocationUnitPrice;
	}

	public void setFleetCenterAllocationUnitPrice(Double fleetCenterAllocationUnitPrice) {
		this.fleetCenterAllocationUnitPrice = fleetCenterAllocationUnitPrice;
	}

	public Double getFleetCenterAllocationTotalPrice() {
		return fleetCenterAllocationTotalPrice;
	}

	public void setFleetCenterAllocationTotalPrice(Double fleetCenterAllocationTotalPrice) {
		this.fleetCenterAllocationTotalPrice = fleetCenterAllocationTotalPrice;
	}

	public Double getTrafficCenterAllocationUnitPrice() {
		return trafficCenterAllocationUnitPrice;
	}

	public void setTrafficCenterAllocationUnitPrice(Double trafficCenterAllocationUnitPrice) {
		this.trafficCenterAllocationUnitPrice = trafficCenterAllocationUnitPrice;
	}

	public Double getTrafficCenterAllocationTotalPrice() {
		return trafficCenterAllocationTotalPrice;
	}

	public void setTrafficCenterAllocationTotalPrice(Double trafficCenterAllocationTotalPrice) {
		this.trafficCenterAllocationTotalPrice = trafficCenterAllocationTotalPrice;
	}

	public Double getCateringCenterAllocationUnitPrice() {
		return cateringCenterAllocationUnitPrice;
	}

	public void setCateringCenterAllocationUnitPrice(Double cateringCenterAllocationUnitPrice) {
		this.cateringCenterAllocationUnitPrice = cateringCenterAllocationUnitPrice;
	}

	public Double getCateringCenterAllocationTotalPrice() {
		return cateringCenterAllocationTotalPrice;
	}

	public void setCateringCenterAllocationTotalPrice(Double cateringCenterAllocationTotalPrice) {
		this.cateringCenterAllocationTotalPrice = cateringCenterAllocationTotalPrice;
	}

	public Double getScenicSpotCenterAllocationUnitPrice() {
		return scenicSpotCenterAllocationUnitPrice;
	}

	public void setScenicSpotCenterAllocationUnitPrice(Double scenicSpotCenterAllocationUnitPrice) {
		this.scenicSpotCenterAllocationUnitPrice = scenicSpotCenterAllocationUnitPrice;
	}

	public Double getScenicSpotCenterAllocationTotalPrice() {
		return scenicSpotCenterAllocationTotalPrice;
	}

	public void setScenicSpotCenterAllocationTotalPrice(Double scenicSpotCenterAllocationTotalPrice) {
		this.scenicSpotCenterAllocationTotalPrice = scenicSpotCenterAllocationTotalPrice;
	}

	public Double getHousingSpotCenterAllocationUnitPrice() {
		return housingSpotCenterAllocationUnitPrice;
	}

	public void setHousingSpotCenterAllocationUnitPrice(Double housingSpotCenterAllocationUnitPrice) {
		this.housingSpotCenterAllocationUnitPrice = housingSpotCenterAllocationUnitPrice;
	}

	public Double getHousingSpotCenterAllocationTotalPrice() {
		return housingSpotCenterAllocationTotalPrice;
	}

	public void setHousingSpotCenterAllocationTotalPrice(Double housingSpotCenterAllocationTotalPrice) {
		this.housingSpotCenterAllocationTotalPrice = housingSpotCenterAllocationTotalPrice;
	}

	public Double getTourGuideSpotCenterAllocationUnitPrice() {
		return tourGuideSpotCenterAllocationUnitPrice;
	}

	public void setTourGuideSpotCenterAllocationUnitPrice(Double tourGuideSpotCenterAllocationUnitPrice) {
		this.tourGuideSpotCenterAllocationUnitPrice = tourGuideSpotCenterAllocationUnitPrice;
	}

	public Double getTourGuideSpotCenterAllocationTotalPrice() {
		return tourGuideSpotCenterAllocationTotalPrice;
	}

	public void setTourGuideSpotCenterAllocationTotalPrice(Double tourGuideSpotCenterAllocationTotalPrice) {
		this.tourGuideSpotCenterAllocationTotalPrice = tourGuideSpotCenterAllocationTotalPrice;
	}

	public Double getVisaCenterAllocationUnitPrice() {
		return visaCenterAllocationUnitPrice;
	}

	public void setVisaCenterAllocationUnitPrice(Double visaCenterAllocationUnitPrice) {
		this.visaCenterAllocationUnitPrice = visaCenterAllocationUnitPrice;
	}

	public Double getVisaCenterAllocationTotalPrice() {
		return visaCenterAllocationTotalPrice;
	}

	public void setVisaCenterAllocationTotalPrice(Double visaCenterAllocationTotalPrice) {
		this.visaCenterAllocationTotalPrice = visaCenterAllocationTotalPrice;
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

	public Integer getInventoryPerson() {
		return inventoryPerson;
	}

	public void setInventoryPerson(Integer inventoryPerson) {
		this.inventoryPerson = inventoryPerson;
	}

	public Double getChildrenPrice() {
		return childrenPrice;
	}

	public void setChildrenPrice(Double childrenPrice) {
		this.childrenPrice = childrenPrice;
	}

	public Double getPriceOfBed() {
		return priceOfBed;
	}

	public void setPriceOfBed(Double priceOfBed) {
		this.priceOfBed = priceOfBed;
	}

	public ChildrenDefineStandard getChildrenDefineStandard() {
		return childrenDefineStandard;
	}

	public void setChildrenDefineStandard(ChildrenDefineStandard childrenDefineStandard) {
		this.childrenDefineStandard = childrenDefineStandard;
	}

	public String getSpecialPopulationDescription() {
		return specialPopulationDescription;
	}

	public void setSpecialPopulationDescription(String specialPopulationDescription) {
		this.specialPopulationDescription = specialPopulationDescription;
	}

	public String getChildrensPriceDescription() {
		return childrensPriceDescription;
	}

	public void setChildrensPriceDescription(String childrensPriceDescription) {
		this.childrensPriceDescription = childrensPriceDescription;
	}

	public Double getWithTheIndustryAdultPrice() {
		return withTheIndustryAdultPrice;
	}

	public void setWithTheIndustryAdultPrice(Double withTheIndustryAdultPrice) {
		this.withTheIndustryAdultPrice = withTheIndustryAdultPrice;
	}

	public Double getWithTheIndustryDiscountPrice() {
		return withTheIndustryDiscountPrice;
	}

	public void setWithTheIndustryDiscountPrice(Double withTheIndustryDiscountPrice) {
		this.withTheIndustryDiscountPrice = withTheIndustryDiscountPrice;
	}

	public Integer getWithTheIndustryInventoryPerson() {
		return withTheIndustryInventoryPerson;
	}

	public void setWithTheIndustryInventoryPerson(Integer withTheIndustryInventoryPerson) {
		this.withTheIndustryInventoryPerson = withTheIndustryInventoryPerson;
	}

	public Double getWithTheIndustryChildrenPrice() {
		return withTheIndustryChildrenPrice;
	}

	public void setWithTheIndustryChildrenPrice(Double withTheIndustryChildrenPrice) {
		this.withTheIndustryChildrenPrice = withTheIndustryChildrenPrice;
	}

	public Double getWithTheIndustryPriceOfBed() {
		return withTheIndustryPriceOfBed;
	}

	public void setWithTheIndustryPriceOfBed(Double withTheIndustryPriceOfBed) {
		this.withTheIndustryPriceOfBed = withTheIndustryPriceOfBed;
	}

	public ChildrenDefineStandard getWithTheIndustryChildrenDefineStandard() {
		return withTheIndustryChildrenDefineStandard;
	}

	public void setWithTheIndustryChildrenDefineStandard(ChildrenDefineStandard withTheIndustryChildrenDefineStandard) {
		this.withTheIndustryChildrenDefineStandard = withTheIndustryChildrenDefineStandard;
	}

	public String getWithTheIndustrySpecialPopulationDescription() {
		return withTheIndustrySpecialPopulationDescription;
	}

	public void setWithTheIndustrySpecialPopulationDescription(String withTheIndustrySpecialPopulationDescription) {
		this.withTheIndustrySpecialPopulationDescription = withTheIndustrySpecialPopulationDescription;
	}

	public String getWithTheIndustryChildrensPriceDescription() {
		return withTheIndustryChildrensPriceDescription;
	}

	public void setWithTheIndustryChildrensPriceDescription(String withTheIndustryChildrensPriceDescription) {
		this.withTheIndustryChildrensPriceDescription = withTheIndustryChildrensPriceDescription;
	}

	public Double getChildrenDiscountPrice() {
		return childrenDiscountPrice;
	}

	public void setChildrenDiscountPrice(Double childrenDiscountPrice) {
		this.childrenDiscountPrice = childrenDiscountPrice;
	}

	public Integer getChildrenDefineStandardValue() {
		return childrenDefineStandardValue;
	}

	public void setChildrenDefineStandardValue(Integer childrenDefineStandardValue) {
		this.childrenDefineStandardValue = childrenDefineStandardValue;
	}

	public Double getWithTheIndustryChildrenDiscountPrice() {
		return withTheIndustryChildrenDiscountPrice;
	}

	public void setWithTheIndustryChildrenDiscountPrice(Double withTheIndustryChildrenDiscountPrice) {
		this.withTheIndustryChildrenDiscountPrice = withTheIndustryChildrenDiscountPrice;
	}

	public Integer getWithTheIndustryChildrenDefineStandardValue() {
		return withTheIndustryChildrenDefineStandardValue;
	}

	public void setWithTheIndustryChildrenDefineStandardValue(Integer withTheIndustryChildrenDefineStandardValue) {
		this.withTheIndustryChildrenDefineStandardValue = withTheIndustryChildrenDefineStandardValue;
	}

}
