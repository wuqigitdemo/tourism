package org.honor.tourism.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * 自营线路其它信息
 * 
 * @author keiwu
 *
 */
@Entity
@Table(name = "t_self_support_route")
public class SelfSupportRouteOtherInfo {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Length(min = 32, max = 32, message = "id需要32位字符")
	private String id;
	/** 购物店 */
	@Length(max = 50, message = "购物店字符不能大于50")
	private String shop;
	/** 特殊限制 */
	@Length(max = 255, message = "特殊限制字符不能大于255")
	private String specialRestrictions;
	/** 预订须知 */
	@Length(max = 255, message = "预订须知字符不能大于255")
	private String reservationInform;
	/** 自费项目备注 */
	@Length(max = 255, message = "自费项目备注字符不能大于255")
	private String selfPayItemRemark;
	/** 自费项目推荐 */
	@Length(max = 255, message = "自费项目推荐字符不能大于255")
	private String selfPayItemRecommend;
	/** 费用包含 */
	@Length(max = 255, message = "费用包含字符不能大于255")
	private String costCover;
	/** 费用不包含 */
	@Length(max = 255, message = "费用不包含字符不能大于255")
	private String costNoCover;
	/** 退款说明 */
	@Length(max = 255, message = "退款说明字符不能大于255")
	private String refundInstruction;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public String getSpecialRestrictions() {
		return specialRestrictions;
	}

	public void setSpecialRestrictions(String specialRestrictions) {
		this.specialRestrictions = specialRestrictions;
	}

	public String getReservationInform() {
		return reservationInform;
	}

	public void setReservationInform(String reservationInform) {
		this.reservationInform = reservationInform;
	}

	public String getSelfPayItemRemark() {
		return selfPayItemRemark;
	}

	public void setSelfPayItemRemark(String selfPayItemRemark) {
		this.selfPayItemRemark = selfPayItemRemark;
	}

	public String getSelfPayItemRecommend() {
		return selfPayItemRecommend;
	}

	public void setSelfPayItemRecommend(String selfPayItemRecommend) {
		this.selfPayItemRecommend = selfPayItemRecommend;
	}

	public String getCostCover() {
		return costCover;
	}

	public void setCostCover(String costCover) {
		this.costCover = costCover;
	}

	public String getCostNoCover() {
		return costNoCover;
	}

	public void setCostNoCover(String costNoCover) {
		this.costNoCover = costNoCover;
	}

	public String getRefundInstruction() {
		return refundInstruction;
	}

	public void setRefundInstruction(String refundInstruction) {
		this.refundInstruction = refundInstruction;
	}

}
