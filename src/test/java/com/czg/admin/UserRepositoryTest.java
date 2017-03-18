package com.czg.admin;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.czg.admin.dao.UserRepository;
import com.czg.admin.domain.Duty;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepo;

	@Test
	public void testUserRep() {
		List<Duty> dutys = userRepo.findAll();
		assertEquals("权限有该用户",dutys.get(0).getName(),"ww");
		
	}
	
}
