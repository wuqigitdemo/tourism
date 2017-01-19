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
 * 行程信息
 * 
 * @author keiwu
 *
 */
@Entity
@Table(name = "t_route_trip")
public class RouteTrip {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Length(min = 32, max = 32, message = "id需要32位字符")
	private String id;
	/** 行程标题 */
	@Length(min = 1, max = 50, message = "行程标题需要1-50位字符")
	private String tripTitle;
	/** 行程详细 */
	@Length(min = 1, max = 50, message = "行程详细需要1-50位字符")
	private String tripDetail;
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="routeTripId")
	private List<RouteDay> routeDayList;
	/** 早餐 */
	@ManyToOne
	private DiningType breakfast;
	/** 午餐 */
	@ManyToOne
	private DiningType lunch;
	/** 晚餐 */
	@ManyToOne
	private DiningType dinner;
	/** 餐饮图片 */
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="routeTripId")
	private List<ImageAddress> foodPictures;
	/** 酒店分类 */
	@ManyToOne
	private HotelCategories hotelCategories;
	/** 酒店图片 */
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="routeTripId")
	private List<ImageAddress> hotelPicture;
	@ManyToOne
	private SelfSupportRoute selfSupportRoute;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTripTitle() {
		return tripTitle;
	}

	public void setTripTitle(String tripTitle) {
		this.tripTitle = tripTitle;
	}

	public String getTripDetail() {
		return tripDetail;
	}

	public void setTripDetail(String tripDetail) {
		this.tripDetail = tripDetail;
	}

	public List<RouteDay> getRouteDayList() {
		return routeDayList;
	}

	public void setRouteDayList(List<RouteDay> routeDayList) {
		this.routeDayList = routeDayList;
	}

	public DiningType getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(DiningType breakfast) {
		this.breakfast = breakfast;
	}

	public DiningType getLunch() {
		return lunch;
	}

	public void setLunch(DiningType lunch) {
		this.lunch = lunch;
	}

	public DiningType getDinner() {
		return dinner;
	}

	public void setDinner(DiningType dinner) {
		this.dinner = dinner;
	}

	public List<ImageAddress> getFoodPictures() {
		return foodPictures;
	}

	public void setFoodPictures(List<ImageAddress> foodPictures) {
		this.foodPictures = foodPictures;
	}

	public HotelCategories getHotelCategories() {
		return hotelCategories;
	}

	public void setHotelCategories(HotelCategories hotelCategories) {
		this.hotelCategories = hotelCategories;
	}

	public List<ImageAddress> getHotelPicture() {
		return hotelPicture;
	}

	public void setHotelPicture(List<ImageAddress> hotelPicture) {
		this.hotelPicture = hotelPicture;
	}

	public SelfSupportRoute getSelfSupportRoute() {
		return selfSupportRoute;
	}

	public void setSelfSupportRoute(SelfSupportRoute selfSupportRoute) {
		this.selfSupportRoute = selfSupportRoute;
	}

}
