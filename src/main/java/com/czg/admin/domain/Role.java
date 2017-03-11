package com.czg.admin.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "role", catalog = "product")
public class Role {
	private Integer rid;
	private String rname;
	private boolean isactive;
	private Integer datascope;
	private String rtype;
	private String remarks;
	private String createuser;
	private Date createdate;
	private String updateuser;
	private Date updatedate;
	private Set<Menu> menus;

	public Role() {
		super();
	}

	public Role(String rname, boolean isactive, Integer datascope, String rtype, String remarks, String createuser,
			Date createdate, String updateuser, Date updatedate) {
		super();
		this.rname = rname;
		this.isactive = isactive;
		this.datascope = datascope;
		this.rtype = rtype;
		this.remarks = remarks;
		this.createuser = createuser;
		this.createdate = createdate;
		this.updateuser = updateuser;
		this.updatedate = updatedate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "r_id", unique = true, nullable = false)
	public Integer getRid() {
		return rid;
	}

	@Column(name = "isactive", nullable = false)
	public boolean getIsactive() {
		return isactive;
	}

	@Column(name = "r_name", nullable = false, length = 20)
	public String getRname() {
		return rname;
	}

	@Column(name = "data_scope", nullable = false)
	public Integer getDatascope() {
		return datascope;
	}

	@Column(name = "r_type", length = 20)
	public String getRtype() {
		return rtype;
	}

	@Column(name = "remarks")
	public String getRemarks() {
		return remarks;
	}

	@Column(name = "update_date")
	public Date getUpdatedate() {
		return updatedate;
	}

	@Column(name = "update_user", nullable = false)
	public String getUpdateuser() {
		return updateuser;
	}

	@Column(name = "create_user", nullable = false)
	public String getCreateuser() {
		return createuser;
	}

	@Column(name = "create_date")
	public Date getCreatedate() {
		return createdate;
	}

	@Transient
	public Set<Menu> getMenus() {
		return menus;
	}

	/*
	 * 
	 * 
	 * set
	 * 
	 * 
	 */
	
	public void setDutys(Set<Menu> menus) {
		this.menus = menus;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public void setDatascope(Integer datascope) {
		this.datascope = datascope;
	}

	public void setRtype(String rtype) {
		this.rtype = rtype;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setUpdatedate(java.util.Date updatedate) {
		this.updatedate = updatedate;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

	public void setCreatedate(java.util.Date createdate) {
		this.createdate = createdate;
	}

}
