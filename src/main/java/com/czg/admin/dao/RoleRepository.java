package com.czg.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
	
	public List<Role> findRoleMenus(Integer id){ 
		String sql = "SELECT role.r_id,role.r_name,menu.menu_id , menu.name FROM role_menu , menu, role "
				+ "where role.r_id=? and role.r_id=role_menu.role_id and role_menu.menu_id=menu.menu_id";
		
		return jdbcTemplate.query(sql, new RoleRowMapper(), id);
	}


	private static final class RoleRowMapper implements RowMapper<Role>{

		@Override
		public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
			 Role role = new Role(rs.getInt("r_id"),rs.getString("r_name"));
			 Menu menu = new Menu(rs.getInt("menu_id"),rs.getString("name"));
			 if(role.getMenus()==null){
				 role.setMenu(new HashSet<Menu>());
			 }
			 role.getMenus().add(menu) ;
			 return role ;
				//Menu menu = new Menu(rs.getInt("menu_id"),rs.getString("name")) l
				
				//role.setMenu(menus);
		}
	}
	
//	public List<Role> findRole(Integer id){ 
//	String sql = "SELECT r_id ,r_name FROM product.role where r_id=?"; 
//			
//			List<Role> roles= null ;
//	
//	return roles=jdbcTemplate.query(sql, new RoleRowMapper(), id);
//}
//
//
//private static final class RoleRowMapper implements RowMapper<Role>{
//
//	@Override
//	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
//		 Role role = new Role(rs.getInt("r_id"),rs.getString("r_name"));
//		 return role ;
//			//Menu menu = new Menu(rs.getInt("menu_id"),rs.getString("name")) l
//			
//			//role.setMenu(menus);
//	}
//}
}
