package org.honor.tourism.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * 日程信息
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
	
}
