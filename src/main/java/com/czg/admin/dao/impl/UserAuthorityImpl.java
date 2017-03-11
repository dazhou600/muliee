package com.czg.admin.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.czg.admin.dao.UserAuthority;
import com.czg.admin.domain.Duty;
import com.czg.admin.domain.SUser;

public class UserAuthorityImpl implements UserAuthority {
	
	
	@PersistenceContext
	private EntityManager em ; 
	
	@Override
	public void rname() {
		String s = "SELECT distinct u.u_name,m.name, m.permission "
	+"FROM duty u, menu m, role r, role_menu rm, user_role ur "
	+ "where u.u_id=1 and u.u_id=ur.user_id and ur.role_id=r.r_id and r.r_id=rm.role_id and rm.menu_id=m.menu_id";
		ArrayList<SUser> ls = (ArrayList<SUser>) em.createQuery(s).getResultList() ;
		
		Iterator it = ls.iterator();
		System.out.println("****************************************");

		while(it.hasNext()){
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

			System.out.println(it.next());
		}
		//return null;
	}

}