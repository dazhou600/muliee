package com.czg.admin.domain;

public class SUser {
 private String uname;
 
 private String mname;

 private String permission;

public String getUname() {
	return uname;
}

public void setUname(String uname) {
	this.uname = uname;
}

public String getMname() {
	return mname;
}

public void setMname(String mname) {
	this.mname = mname;
}

public String getPermission() {
	return permission;
}

public void setPermission(String permission) {
	this.permission = permission;
}

@Override
public String toString() {
	return "SUser [uname=" + uname + ", mname=" + mname + ", permission=" + permission + "]";
}
  
 

}
