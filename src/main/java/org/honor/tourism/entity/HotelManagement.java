package org.honor.tourism.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * 酒店管理
 * 
 * @author keiwu
 *
 */
@Entity
@Table(name = "t_hotel_management")
public class HotelManagement {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;
	/** 酒店名称 */
	@Length(min = 2, max = 30, message = "酒店名称需要2-30位字符")
	private String hotelName;
	/** 级别 */
	@Length(min = 2, max = 30, message = "级别需要2-30位字符")
	@ManyToOne
	private HotelLevel hotelLevel;
	/** 联系电话 */
	@Length(min = 6, max = 11, message = "联系电话需要6-11位字符")
	private String phone;
	/** 地址 */
	@Length(min = 0, max = 100, message = "地址不能超过100个字符")
	private String address;
	/** 所在城市 */
	@ManyToOne
	private City city;
	/** 所在商圈 */
	@Length(min = 0, max = 100, message = "所在商圈不能超过100个字符")
	private String businessDistrict;
	/** 酒店类型 */
	@ManyToOne
	private HotelCategories hotelCategories;
	/** 评分 */
	private String score;
	/** 提供服务 */
	@ManyToOne
	private HotelProvideService hotelProvideService;
	/** 酒店缩略图 */
	private String hotelThumbnails;
	/** 是否热门酒店 */
	private boolean popularHotels;
	/** 部门名称 */
	@ManyToOne
	private Department department;
	/** 简介 */
	private String introduction;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public HotelLevel getHotelLevel() {
		return hotelLevel;
	}

	public void setHotelLevel(HotelLevel hotelLevel) {
		this.hotelLevel = hotelLevel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getBusinessDistrict() {
		return businessDistrict;
	}

	public void setBusinessDistrict(String businessDistrict) {
		this.businessDistrict = businessDistrict;
	}

	public HotelCategories getHotelCategories() {
		return hotelCategories;
	}

	public void setHotelCategories(HotelCategories hotelCategories) {
		this.hotelCategories = hotelCategories;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public HotelProvideService getHotelProvideService() {
		return hotelProvideService;
	}

	public void setHotelProvideService(HotelProvideService hotelProvideService) {
		this.hotelProvideService = hotelProvideService;
	}

	public String getHotelThumbnails() {
		return hotelThumbnails;
	}

	public void setHotelThumbnails(String hotelThumbnails) {
		this.hotelThumbnails = hotelThumbnails;
	}

	public boolean isPopularHotels() {
		return popularHotels;
	}

	public void setPopularHotels(boolean popularHotels) {
		this.popularHotels = popularHotels;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

}
