package com.czg.admin.domain;

import java.sql.*;
import java.util.*;

public class Role_menu {

	private Integer role_id;
	private Integer menu_id;


	public Integer getRole_id(){
		return role_id;
	}
	public Integer getMenu_id(){
		return menu_id;
	}
	public void setRole_id(Integer role_id){
		this.role_id=role_id;
	}
	public void setMenu_id(Integer menu_id){
		this.menu_id=menu_id;
	}
}
