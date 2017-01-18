package org.honor.tourism.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * 级联删除测试
 * @author keiwu
 *
 */
@Entity
@Table(name = "t_demo_children")
public class DemoChildren {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Length(min = 32, max = 32, message = "id需要32位字符")
	private String id;
	@Length(min = 1, max = 30, message = "demoChildrenName需要1-30位字符")
	private String demoChildrenName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDemoChildrenName() {
		return demoChildrenName;
	}

	public void setDemoChildrenName(String demoChildrenName) {
		this.demoChildrenName = demoChildrenName;
	}

}
