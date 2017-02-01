package com.czg.admin.domain;

import java.sql.*;
import java.util.*;

public class Role {

	private String update_user;
	private boolean isactive;
	private String create_user;
	private java.util.Date create_date;
	private Integer r_id;
	private Integer data_scope;
	private String r_name;
	private String r_type;
	private String remarks;
	private java.util.Date update_date;


	public String getUpdate_user(){
		return update_user;
	}
	public boolean getIsactive(){
		return isactive;
	}
	public String getCreate_user(){
		return create_user;
	}
	public java.util.Date getCreate_date(){
		return create_date;
	}
	public Integer getR_id(){
		return r_id;
	}
	public Integer getData_scope(){
		return data_scope;
	}
	public String getR_name(){
		return r_name;
	}
	public String getR_type(){
		return r_type;
	}
	public String getRemarks(){
		return remarks;
	}
	public java.util.Date getUpdate_date(){
		return update_date;
	}
	public void setUpdate_user(String update_user){
		this.update_user=update_user;
	}
	public void setIsactive(boolean isactive){
		this.isactive=isactive;
	}
	public void setCreate_user(String create_user){
		this.create_user=create_user;
	}
	public void setCreate_date(java.util.Date create_date){
		this.create_date=create_date;
	}
	public void setR_id(Integer r_id){
		this.r_id=r_id;
	}
	public void setData_scope(Integer data_scope){
		this.data_scope=data_scope;
	}
	public void setR_name(String r_name){
		this.r_name=r_name;
	}
	public void setR_type(String r_type){
		this.r_type=r_type;
	}
	public void setRemarks(String remarks){
		this.remarks=remarks;
	}
	public void setUpdate_date(java.util.Date update_date){
		this.update_date=update_date;
	}
}
