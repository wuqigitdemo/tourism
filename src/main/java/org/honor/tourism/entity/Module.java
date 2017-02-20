package org.honor.tourism.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 模块权限
 * 
 * @author keiwu
 *
 */
@Entity
@Table(name = "t_module")
public class Module {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;
	/** 模块名称 */
	@Length(min = 1, max = 32, message = "模块名称需要1-32位字符")
	private String moduleName;
	/** 链接地址 */
	private String linkddress;
	/** 父级模块 */
	@ManyToOne
	private Module parentModule;
	/** 模块排序 */
	private Integer moduleSort;
	@ManyToMany(mappedBy = "moduleList", cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<SysRole> sysRoleList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Module getParentModule() {
		return parentModule;
	}

	public void setParentModule(Module parentModule) {
		this.parentModule = parentModule;
	}

	public Integer getModuleSort() {
		return moduleSort;
	}

	public void setModuleSort(Integer moduleSort) {
		this.moduleSort = moduleSort;
	}

	public String getLinkddress() {
		return linkddress;
	}

	public void setLinkddress(String linkddress) {
		this.linkddress = linkddress;
	}

	public List<SysRole> getSysRoleList() {
		return sysRoleList;
	}

	public void setSysRoleList(List<SysRole> sysRoleList) {
		this.sysRoleList = sysRoleList;
	}

}
