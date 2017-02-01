package com.czg.admin.domain;

import java.sql.*;
import java.util.*;

public class Syslog {

	private String exception;
	private Integer syslog_id;
	private String u_id;
	private String method;
	private String remark;
	private String params;
	private String uip;
	private String request_uri;
	private String user_agent;


	public String getException(){
		return exception;
	}
	public Integer getSyslog_id(){
		return syslog_id;
	}
	public String getU_id(){
		return u_id;
	}
	public String getMethod(){
		return method;
	}
	public String getRemark(){
		return remark;
	}
	public String getParams(){
		return params;
	}
	public String getUip(){
		return uip;
	}
	public String getRequest_uri(){
		return request_uri;
	}
	public String getUser_agent(){
		return user_agent;
	}
	public void setException(String exception){
		this.exception=exception;
	}
	public void setSyslog_id(Integer syslog_id){
		this.syslog_id=syslog_id;
	}
	public void setU_id(String u_id){
		this.u_id=u_id;
	}
	public void setMethod(String method){
		this.method=method;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
	public void setParams(String params){
		this.params=params;
	}
	public void setUip(String uip){
		this.uip=uip;
	}
	public void setRequest_uri(String request_uri){
		this.request_uri=request_uri;
	}
	public void setUser_agent(String user_agent){
		this.user_agent=user_agent;
	}
}
