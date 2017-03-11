package com.czg.admin.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;

import java.util.Set;

import javax.persistence.CascadeType;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "duty", catalog = "product")
public class Duty {

	private String id;
	private String name;
	private boolean isactive;
	private String mobile;
	private String photo;
	private java.util.Date logindate;
	private String remark;
	private String loginip;
	private String password;
	private java.util.Date expiredate;
	private java.util.Date lastupdate;
	private java.util.Date createdate;
	private String email;
	private Set<Role> rols;

	@Id
	@Column(name = "u_id", unique = true, nullable = false)
	public String getId() {
		return id;
	}

	@Column(name = "u_name", length = 20)
	public String getName() {
		return name;
	}

	@Column(name = "isactive")
	public boolean getIsactive() {
		return isactive;
	}

	@Column(name = "mobile", length = 20)
	public String getMobile() {
		return mobile;
	}

	@Column(name = "photo", length = 20)
	public String getPhoto() {
		return photo;
	}

	@Column(name = "login_date")
	public java.util.Date getLogindate() {
		return logindate;
	}

	@Length(min = 5, max = 200, message = "备注长度必须介于 1 和 200 之间")
	@Column(name = "remark", length = 100)
	public String getRemark() {
		return remark;
	}

	@Column(name = "login_ip", length = 120)
	public String getLoginip() {
		return loginip;
	}

	@Column(name = "password", length = 64)
	@Length(min = 6, max = 200, message = "密码长度必须介于 6 和 16 之间")
	public String getPassword() {
		return password;
	}

	@Column(name = "expire_date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public java.util.Date getExpiredate() {
		return expiredate;
	}

	@Column(name = "last_update")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public java.util.Date getLastupdate() {
		return lastupdate;
	}

	@Column(name = "create_date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public java.util.Date getCreatedate() {
		return createdate;
	}

	@Column(name = "email", length = 60)
	public String getEmail() {
		return email;
	}
	@Transient
	public Set<Role> getRols() {
		return rols;
	}

	public void setRols(Set<Role> rols) {
		this.rols = rols;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setLogindate(java.util.Date logindate) {
		this.logindate = logindate;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setExpiredate(java.util.Date expiredate) {
		this.expiredate = expiredate;
	}

	public void setLastupdate(java.util.Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public void setCreatedate(java.util.Date createdate) {
		this.createdate = createdate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
