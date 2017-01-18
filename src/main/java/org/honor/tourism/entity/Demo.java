package org.honor.tourism.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * 级联删除测试
 * @author keiwu
 *
 */
@Entity
@Table(name = "t_demo")
public class Demo {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Length(min = 32, max = 32, message = "id需要32位字符")
	private String id;
	@Length(min = 1, max = 30, message = "demoName1-30位字符")
	private String demoName;
	@OneToMany(cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
	@JoinColumn(name="demoId")
	private List<DemoChildren> demoChildrenList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDemoName() {
		return demoName;
	}

	public void setDemoName(String demoName) {
		this.demoName = demoName;
	}

	public List<DemoChildren> getDemoChildrenList() {
		return demoChildrenList;
	}

	public void setDemoChildrenList(List<DemoChildren> demoChildrenList) {
		this.demoChildrenList = demoChildrenList;
	}

}
