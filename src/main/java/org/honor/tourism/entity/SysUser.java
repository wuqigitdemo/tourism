package org.honor.tourism.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户表
 * 
 * @author keiwu
 *
 */
@Entity
@Table(name = "t_sys_user")
public class SysUser implements UserDetails {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;
	/** 用户名 */
	@Length(min = 4, max = 30, message = "{SysUser.username}")
	@Column(nullable = false, unique = true)
	private String username;
	/** 密码 */
	@Length(min = 5, max = 50, message = "{SysUser.password}")
	private String password;
	@ManyToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	private List<SysRole> roles;
	/** 姓名 */
	@Length(min = 1, max = 30, message = "姓名不能少于1位字符")
	private String name;
	/** 所属部门 */
	@ManyToOne
	private Department department;
	/** 职务 */
	private String duty;
	/** 电话 */
	private String phone;
	/** 手机 */
	private String mobilePhone;
	/** 电子邮箱 */
	private String emailAddress;
	/** 同级排序 */
	private Integer siblingSorting;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		List<SysRole> roles = this.getRoles();
		for (SysRole sysRole : roles) {
			auths.add(new SimpleGrantedAuthority(sysRole.getName())); //"ROLE_" + 
		}
		return auths;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Integer getSiblingSorting() {
		return siblingSorting;
	}

	public void setSiblingSorting(Integer siblingSorting) {
		this.siblingSorting = siblingSorting;
	}

}
