package com.czg.admin.domain;

import java.sql.*;
import java.util.*;

public class Menu {

	private boolean isactive;
	private String icon;
	private String permission;
	private Integer sort;
	private boolean is_show;
	private java.util.Date update_date;
	private String create_by;
	private String name;
	private String href;
	private java.util.Date create_date;
	private String update_by;
	private Integer menu_id;
	private String remarks;


	public boolean getIsactive(){
		return isactive;
	}
	public String getIcon(){
		return icon;
	}
	public String getPermission(){
		return permission;
	}
	public Integer getSort(){
		return sort;
	}
	public boolean getIs_show(){
		return is_show;
	}
	public java.util.Date getUpdate_date(){
		return update_date;
	}
	public String getCreate_by(){
		return create_by;
	}
	public String getName(){
		return name;
	}
	public String getHref(){
		return href;
	}
	public java.util.Date getCreate_date(){
		return create_date;
	}
	public String getUpdate_by(){
		return update_by;
	}
	public Integer getMenu_id(){
		return menu_id;
	}
	public String getRemarks(){
		return remarks;
	}
	public void setIsactive(boolean isactive){
		this.isactive=isactive;
	}
	public void setIcon(String icon){
		this.icon=icon;
	}
	public void setPermission(String permission){
		this.permission=permission;
	}
	public void setSort(Integer sort){
		this.sort=sort;
	}
	public void setIs_show(boolean is_show){
		this.is_show=is_show;
	}
	public void setUpdate_date(java.util.Date update_date){
		this.update_date=update_date;
	}
	public void setCreate_by(String create_by){
		this.create_by=create_by;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setHref(String href){
		this.href=href;
	}
	public void setCreate_date(java.util.Date create_date){
		this.create_date=create_date;
	}
	public void setUpdate_by(String update_by){
		this.update_by=update_by;
	}
	public void setMenu_id(Integer menu_id){
		this.menu_id=menu_id;
	}
	public void setRemarks(String remarks){
		this.remarks=remarks;
	}
}
