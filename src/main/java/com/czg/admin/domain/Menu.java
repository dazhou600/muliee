package com.czg.admin.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "menu", catalog = "product")
public class Menu {

	private Integer menuid;
	private boolean isactive;
	private String icon;
	private String permission;
	private Integer sort;
	private boolean isshow;
	private Date updatedate;
	private String createby;
	private String name;
	private String href;
	private Date createdate;
	private String updateby;
	private String remarks;

	
	@Id
	@Column(name = "menu_id", unique = true, nullable = false)
	public Integer getMenuid() {
		return menuid;
	}

	@Column(name = "isactive")
	public boolean getIsactive() {
		return isactive;
	}

	@Column(name = "icon", length = 20)
	public String getIcon() {
		return icon;
	}

	@Column(name = "Permission", nullable=false,length = 20)
	public String getPermission() {
		return permission;
	}

	@Column(name = "sort")
	public Integer getSort() {
		return sort;
	}

	
	@Column(name = "is_show")
	public boolean getIsshow() {
		return isshow;
	}

	
	@Column(name = "update_date")
	public Date getUpdatedate() {
		return updatedate;
	}

	@Column(name = "Create_by", length = 20)
	public String getCreateby() {
		return createby;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return name;
	}

	@Column(name = "href", length = 100)
	public String getHref() {
		return href;
	}

	@Column(name = "create_date")
	public Date getCreatedate() {
		return createdate;
	}

	@Column(name = "update_by", length = 50)
	public String getUpdateby() {
		return updateby;
	}

	@Column(name = "remarks", length = 256)
	public String getRemarks() {
		return remarks;
	}
	/*
	 * 
	 * set
	 * 
	 */

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public void setIsshow(boolean isshow) {
		this.isshow = isshow;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", isactive=" + isactive + ", icon=" + icon + ", permission=" + permission
				+ ", sort=" + sort + ", isshow=" + isshow + ", updatedate=" + updatedate + ", createby=" + createby
				+ ", name=" + name + ", href=" + href + ", createdate=" + createdate + ", updateby=" + updateby
				+ ", remarks=" + remarks + "]";
	}
}
