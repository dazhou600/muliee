package com.czg.admin.domain;

import java.sql.*;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "duty", catalog = "product")
public class Duty {

	private String u_id;
	private String u_name;
	private boolean isactive;
	private String mobile;
	private String photo;
	private java.util.Date login_date;
	private String remark;
	private String login_ip;
	private String password;
	private java.util.Date expire_date;
	private java.util.Date last_update;
	private java.util.Date create_date;
	private String email;

	@Id
	@Column(name = "u_id", unique = true, nullable = false)
	public String getU_id() {
		return u_id;
	}

	@Column(name = "u_name", length = 20)
	public String getU_name() {
		return u_name;
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
	public java.util.Date getLogin_date() {
		return login_date;
	}

	@Column(name = "remark", length = 100)
	public String getRemark() {
		return remark;
	}

	@Column(name = "login_ip", length = 120)
	public String getLogin_ip() {
		return login_ip;
	}

	@Column(name = "password", length = 64)
	public String getPassword() {
		return password;
	}

	@Column(name = "expire_date")
	public java.util.Date getExpire_date() {
		return expire_date;
	}

	@Column(name = "last_update")
	public java.util.Date getLast_update() {
		return last_update;
	}

	@Column(name = "create_date")
	public java.util.Date getCreate_date() {
		return create_date;
	}

	@Column(name = "email", length = 60)
	public String getEmail() {
		return email;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
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

	public void setLogin_date(java.util.Date login_date) {
		this.login_date = login_date;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public void setExpire_date(java.util.Date expire_date) {
		this.expire_date = expire_date;
	}

	public void setLast_update(java.util.Date last_update) {
		this.last_update = last_update;
	}

	public void setCreate_date(java.util.Date create_date) {
		this.create_date = create_date;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
