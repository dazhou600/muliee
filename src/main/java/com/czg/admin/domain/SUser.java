package com.czg.admin.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SUser implements Serializable ,UserDetails{

	private static final long serialVersionUID = -6718128562929252469L;

	private int uid;

	private String uname;

	private String rname;
	
	private String password;

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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return uname;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
