package org.honor.tourism.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * 图片地址
 * 
 * @author keiwu
 *
 */
@Entity
@Table(name = "t_image_address")
public class ImageAddress {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Length(min = 32, max = 32, message = "id需要32位字符")
	private String id;
	/** 图片地址 */
	private String imageAddress;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImageAddress() {
		return imageAddress;
	}

	public void setImageAddress(String imageAddress) {
		this.imageAddress = imageAddress;
	}

}
