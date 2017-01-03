package org.honor.tourism.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 日程信息
 * 
 * @author keiwu
 *
 */
@Entity
@Table(name = "t_route_day")
public class RouteDay {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Length(min = 32, max = 32, message = "id需要32位字符")
	private String id;
	/** 选择时间 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date selectionTime;
	/** 日程简单说明 */
	private String simplenessExplain;
	/** 日程详细说明 */
	private String detailednessExplain;
	/** 日程图片 */
	@OneToMany(cascade={CascadeType.ALL})
	private List<ImageAddress> routeDayImageAddress;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getSelectionTime() {
		return selectionTime;
	}

	public void setSelectionTime(Date selectionTime) {
		this.selectionTime = selectionTime;
	}

	public String getSimplenessExplain() {
		return simplenessExplain;
	}

	public void setSimplenessExplain(String simplenessExplain) {
		this.simplenessExplain = simplenessExplain;
	}

	public String getDetailednessExplain() {
		return detailednessExplain;
	}

	public void setDetailednessExplain(String detailednessExplain) {
		this.detailednessExplain = detailednessExplain;
	}

	public List<ImageAddress> getRouteDayImageAddress() {
		return routeDayImageAddress;
	}

	public void setRouteDayImageAddress(List<ImageAddress> routeDayImageAddress) {
		this.routeDayImageAddress = routeDayImageAddress;
	}

}
