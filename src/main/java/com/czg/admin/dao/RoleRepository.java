package com.czg.admin.dao;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.czg.admin.domain.Menu;
import com.czg.admin.domain.Role;

@Repository
public class RoleRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public RoleRepository(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate= jdbcTemplate ;
		
	}

	
	//public Role findByRname(String rname);
	//@Query("SELECT menu.menu_id , menu.name FROM role_menu , menu, role where role.r_id=1 and role.r_id=role_menu.role_id and role_menu.menu_id=menu.menu_id ")
	
	public Set<Menu> findMenus(){
		
		
		return null;
	}


}
