package com.czg.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.czg.admin.domain.Menu;
import com.czg.admin.domain.SUser;

@Repository
public class SUserRepository {

	private JdbcTemplate jdbcTemplate;
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public SUserRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;

	}

	public SUser findPemission(int id) {
		List<SUser> susers = findSUser(id);
		if (susers == null) {
			throw new UsernameNotFoundException("Use: " + id + " not found");
		}

		SUser suser = new SUser();
		suser.setUid(susers.get(0).getUid());
		suser.setUname(susers.get(0).getUname());
		suser.setPermissions(new ArrayList<Menu>());
		suser.setRnames(new ArrayList<String>());
		for (SUser dbuser : susers) {
			// 判断数据库返回的角色字符串有值，并且不重复
			if (StringUtils.hasText(dbuser.getRname())) {
				if (suser.getRnames().isEmpty() || (!suser.getRnames().contains(dbuser.getRname()))) {
					suser.getRnames().add(dbuser.getRname());
				}
			}
			// 权限添加 并且不重复
			if (StringUtils.hasText(dbuser.getPermission())) {
				//System.out.println("*******************"+suser.getPermissions());
				if (suser.getPermissions().isEmpty() || (!isContain(suser.getPermissions(),dbuser.getPermission(),dbuser.getIsactive()))) {
					Menu menu = new Menu(dbuser.getIsactive(), dbuser.getPermission());
					suser.getPermissions().add(menu);
				}
			}
		}
		return suser;
	}
	
	private boolean isContain(List<Menu> menus,String permission,int isactive){
		for(Menu menu:menus){
			if(menu.getPermission().equals(permission)){
				if(menu.getIsactive()>=isactive){
					return true ;
				}else {
					menu.setIsactive(isactive);
					//System.out.println("****menu.setIsactive(isactive):"+isactive+"**************");
					return true ;
				}
			}
		}
		return false;
	}

	private List<SUser> findSUser(int id) {
		String sql = "SELECT distinct u.u_id uid, u.u_name uname,r.r_name rname,m.isactive isactive, m.permission permission "
				+ "FROM duty u, menu m, role r, role_menu rm, user_role ur "
				+ "where u.u_id=? and u.u_id=ur.user_id and ur.role_id=r.r_id and r.r_id=rm.role_id and rm.menu_id=m.menu_id";
		List<SUser> susers = null;

		return susers = jdbcTemplate.query(sql, new SUserRoleRowMapper(), id);
	}

	private final class SUserRoleRowMapper implements RowMapper<SUser> {
		@Override
		public SUser mapRow(ResultSet rs, int rowNum) throws SQLException {
			SUser suser = new SUser(rs.getInt("uid"), rs.getString("uname"), rs.getString("rname"),
					rs.getString("permission"), rs.getInt("isactive"));

			return suser;
		}
	}
}
