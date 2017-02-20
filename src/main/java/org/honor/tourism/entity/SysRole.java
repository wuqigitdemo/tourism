package org.honor.tourism.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 角色表
 * 
 * @author keiwu
 *
 */
@Entity
@Table(name = "t_sys_role")
public class SysRole {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;
	/** 角色名 */
	private String name;
	/** 角色编号 */
	private String roleNumber;
	/** 排序 */
	private Integer sort;
	/** 角色状态 */
	private boolean state;
	@ManyToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Module> moduleList;
	@ManyToMany(mappedBy="roles",cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<SysUser> users;
	
	public List<SysUser> getUsers()
	{
		return users;
	}

	public void setUsers(List<SysUser> users)
	{
		this.users = users;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoleNumber() {
		return roleNumber;
	}

	public void setRoleNumber(String roleNumber) {
		this.roleNumber = roleNumber;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public List<Module> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<Module> moduleList) {
		this.moduleList = moduleList;
	}

}
