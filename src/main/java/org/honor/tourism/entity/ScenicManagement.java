package org.honor.tourism.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * 景区管理
 * 
 * @author keiwu
 *
 */
@Entity
@Table(name = "t_scenic_management")
public class ScenicManagement {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;
	/** 景区编号 */
	private Integer scenicNumber;
	/** 景区名称 */
	@Length(min = 2, max = 30, message = "景区名称需要2-30位字符")
	private String scenicName;
	/** 部门名称 */
	@ManyToOne
	private Department department;
	/** 所属地区 */
	@ManyToOne
	private City city;
	/** 评级 */
	private Integer scenicRating;
	/** 电话 */
	@Length(min = 6, max = 11, message = "电话需要6-11位字符")
	private String phone;
	/** 地址 */
	@Length(min = 1, max = 100, message = "地址需要2-100位字符")
	private String address;
	/** 是否是热门景区 */
	private boolean popularScenicSpots;
	/** 是否推荐至首页 */
	private boolean recommendedHome;
	/** 评分 */
	private Integer scenicScore;
	/** 相册 */
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "scenicManagementPhotoAlbum")
	private List<ImageAddress> photoAlbum;
	/** 景区地图 */
	private String scenicMap;
	/** 开放时间 */
	private String openTime;
	/** 交通信息 */
	private String trafficInformation;
	/** 简图 */
	private String simplifiedDiagram;
	/** 景区视频 */
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "scenicManagementScenicVideo")
	private List<ImageAddress> scenicVideo;
	/** 导览图 */
	private String guideMap;
	/** 导游词 */
	private String guideWords;
	/** 景区简介 */
	private String scenicSpotIntroduction;
	/** 服务承诺 */
	private String servicePromise;
	/** 预订须知 */
	private String bookingInformation;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getScenicName() {
		return scenicName;
	}

	public void setScenicName(String scenicName) {
		this.scenicName = scenicName;
	}

	public Integer getScenicNumber() {
		return scenicNumber;
	}

	public void setScenicNumber(Integer scenicNumber) {
		this.scenicNumber = scenicNumber;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Integer getScenicRating() {
		return scenicRating;
	}

	public void setScenicRating(Integer scenicRating) {
		this.scenicRating = scenicRating;
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

	public boolean isPopularScenicSpots() {
		return popularScenicSpots;
	}

	public void setPopularScenicSpots(boolean popularScenicSpots) {
		this.popularScenicSpots = popularScenicSpots;
	}

	public boolean isRecommendedHome() {
		return recommendedHome;
	}

	public void setRecommendedHome(boolean recommendedHome) {
		this.recommendedHome = recommendedHome;
	}

	public Integer getScenicScore() {
		return scenicScore;
	}

	public void setScenicScore(Integer scenicScore) {
		this.scenicScore = scenicScore;
	}

	public List<ImageAddress> getPhotoAlbum() {
		return photoAlbum;
	}

	public void setPhotoAlbum(List<ImageAddress> photoAlbum) {
		this.photoAlbum = photoAlbum;
	}

	public String getScenicMap() {
		return scenicMap;
	}

	public void setScenicMap(String scenicMap) {
		this.scenicMap = scenicMap;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getTrafficInformation() {
		return trafficInformation;
	}

	public void setTrafficInformation(String trafficInformation) {
		this.trafficInformation = trafficInformation;
	}

	public String getSimplifiedDiagram() {
		return simplifiedDiagram;
	}

	public void setSimplifiedDiagram(String simplifiedDiagram) {
		this.simplifiedDiagram = simplifiedDiagram;
	}

	public List<ImageAddress> getScenicVideo() {
		return scenicVideo;
	}

	public void setScenicVideo(List<ImageAddress> scenicVideo) {
		this.scenicVideo = scenicVideo;
	}

	public String getGuideMap() {
		return guideMap;
	}

	public void setGuideMap(String guideMap) {
		this.guideMap = guideMap;
	}

	public String getGuideWords() {
		return guideWords;
	}

	public void setGuideWords(String guideWords) {
		this.guideWords = guideWords;
	}

	public String getScenicSpotIntroduction() {
		return scenicSpotIntroduction;
	}

	public void setScenicSpotIntroduction(String scenicSpotIntroduction) {
		this.scenicSpotIntroduction = scenicSpotIntroduction;
	}

	public String getServicePromise() {
		return servicePromise;
	}

	public void setServicePromise(String servicePromise) {
		this.servicePromise = servicePromise;
	}

	public String getBookingInformation() {
		return bookingInformation;
	}

	public void setBookingInformation(String bookingInformation) {
		this.bookingInformation = bookingInformation;
	}

}
