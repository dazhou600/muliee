package com.czg.admin;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.czg.admin.dao.SUserRepository;
import com.czg.admin.domain.Menu;
import com.czg.admin.domain.SUser;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SUserRepositoryTest {

	@Autowired
	private SUserRepository repo;
	@Test
	public void test() {
		//fail("Not yet implemented");
		SUser suser = repo.findPemission(1);
		StringBuilder sb = new StringBuilder();
		//System.out.println("_____________"+suser.getPermissions());
		for(String rname:suser.getRnames()){
			sb.append("[").append(rname).append("]");
		}
		sb.append("{");
		for(Menu menu:suser.getPermissions()){
			sb.append(menu.getPermission()).append("-->").append(menu.getIsactive()).append(",");
		}
		sb.append("}");
		System.out.println("用户id："+suser.getUid() +"用户姓名："+ suser.getUname() +"角色："
		+sb.toString());
		assertEquals("权限大小一致",suser.getPermissions().size(),4);
		assertEquals("角色大小一致",suser.getRnames().size(),3); 

	}

}
