package com.czg.admin.domain;

import java.io.Serializable;
import java.util.List;

public class SUser implements Serializable {

	private static final long serialVersionUID = -6718128562929252469L;

	private int uid;

	private String uname;

	private String rname;

	private String permission;

	private int isactive;

	private List<String> rnames;

	private List<Menu> permissions;

	public SUser() {
		super();
	}

	public SUser(int uid, String uname, String rname, String permission, int isactive) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.rname = rname;
		this.permission = permission;
		this.isactive = isactive;
	}

	public String getRname() {
		return rname;
	}

	public String getPermission() {
		return permission;
	}

	public int getIsactive() {
		return isactive;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public List<String> getRnames() {
		return rnames;
	}

	public void setRnames(List<String> rnames) {
		this.rnames = rnames;
	}

	public List<Menu> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Menu> permissions) {
		this.permissions = permissions;
	}

}
