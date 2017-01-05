package org.honor.tourism.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * 线路基础信息
 */
@Entity
@Table(name = "t_route_base_info")
public class RouteBaseInfo {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Length(min = 32, max = 32, message = "id需要32位字符")
	private String id;
	/** 线路名称 */
	@Length(min = 1, max = 100, message = "线路名称需要1-100位字符")
	private String routeName;
	/** 去程交通 */
	@ManyToOne
	private Traffic goTraffic;
	/** 回程交通 */
	@ManyToOne
	private Traffic returnTraffic;
	/** 出发地 */
	@Length(min = 1, max = 50, message = "出发地称需要1-50位字符")
	private String outPlace;
	/** 浏览地 */
	@Length(min = 1, max = 50, message = "浏览地需要1-50位字符")
	private String destination;
	/** 签证国家 */
	@ManyToOne
	private VisaNationals visaNationals;
	/** 电商页面排序 */
	private Integer pageOrder;
	@ManyToMany
	private List<RouteType> routeTypeList;
	/** 线路列表简图 */
	private String listRouteDiagram;
	/** 路线简图 */
	private String routeDiagram;
	@ManyToOne
	private TourismTheme tourismTheme;
	/** 起价说明 */
	@Length(min = 0, max = 100, message = "起价说明需要1-100位字符")
	private String startPriceExplain;
	/** 推荐理由 */
	@Length(min = 0, max = 100, message = "推荐理由需要1-100位字符")
	private String recommendedReason;
	/** 重要提示 */
	@Length(min = 0, max = 100, message = "重要提示需要1-100位字符")
	private String importanceHint;
	/** 保险赠送情况说明 */
	@Length(min = 0, max = 100, message = "保险赠送情况说明需要1-100位字符")
	private String insuranceGiveExplain;
	/** 限制报名期限 */
	private Integer limitedRegistrationDeadline;
	/** 限制付款天数 */
	private Integer restrictedPaymentDays;
	/** 限制付款小时 */
	private Integer limitedPaymentHours;
	/** 付款方式 */
	@Length(min = 0, max = 100, message = "付款方式需要1-100位字符")
	private String paymentMethod;
	public Integer getRestrictedPaymentDays() {
		return restrictedPaymentDays;
	}

	public void setRestrictedPaymentDays(Integer restrictedPaymentDays) {
		this.restrictedPaymentDays = restrictedPaymentDays;
	}

	public Integer getLimitedPaymentHours() {
		return limitedPaymentHours;
	}

	public void setLimitedPaymentHours(Integer limitedPaymentHours) {
		this.limitedPaymentHours = limitedPaymentHours;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public Traffic getGoTraffic() {
		return goTraffic;
	}

	public void setGoTraffic(Traffic goTraffic) {
		this.goTraffic = goTraffic;
	}

	public Traffic getReturnTraffic() {
		return returnTraffic;
	}

	public void setReturnTraffic(Traffic returnTraffic) {
		this.returnTraffic = returnTraffic;
	}

	public String getOutPlace() {
		return outPlace;
	}

	public void setOutPlace(String outPlace) {
		this.outPlace = outPlace;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public VisaNationals getVisaNationals() {
		return visaNationals;
	}

	public void setVisaNationals(VisaNationals visaNationals) {
		this.visaNationals = visaNationals;
	}

	public Integer getPageOrder() {
		return pageOrder;
	}

	public void setPageOrder(Integer pageOrder) {
		this.pageOrder = pageOrder;
	}

	public List<RouteType> getRouteTypeList() {
		return routeTypeList;
	}

	public void setRouteTypeList(List<RouteType> routeTypeList) {
		this.routeTypeList = routeTypeList;
	}

	public String getListRouteDiagram() {
		return listRouteDiagram;
	}

	public void setListRouteDiagram(String listRouteDiagram) {
		this.listRouteDiagram = listRouteDiagram;
	}

	public String getRouteDiagram() {
		return routeDiagram;
	}

	public void setRouteDiagram(String routeDiagram) {
		this.routeDiagram = routeDiagram;
	}

	public TourismTheme getTourismTheme() {
		return tourismTheme;
	}

	public void setTourismTheme(TourismTheme tourismTheme) {
		this.tourismTheme = tourismTheme;
	}

	public String getStartPriceExplain() {
		return startPriceExplain;
	}

	public void setStartPriceExplain(String startPriceExplain) {
		this.startPriceExplain = startPriceExplain;
	}

	public String getRecommendedReason() {
		return recommendedReason;
	}

	public void setRecommendedReason(String recommendedReason) {
		this.recommendedReason = recommendedReason;
	}

	public String getImportanceHint() {
		return importanceHint;
	}

	public void setImportanceHint(String importanceHint) {
		this.importanceHint = importanceHint;
	}

	public String getInsuranceGiveExplain() {
		return insuranceGiveExplain;
	}

	public void setInsuranceGiveExplain(String insuranceGiveExplain) {
		this.insuranceGiveExplain = insuranceGiveExplain;
	}

	public Integer getLimitedRegistrationDeadline() {
		return limitedRegistrationDeadline;
	}

	public void setLimitedRegistrationDeadline(Integer limitedRegistrationDeadline) {
		this.limitedRegistrationDeadline = limitedRegistrationDeadline;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}