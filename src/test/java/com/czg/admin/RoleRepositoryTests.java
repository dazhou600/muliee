package com.czg.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.czg.admin.dao.RoleRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleRepositoryTests {

	@Autowired
	private RoleRepository rolerepo;

	@Test
	public void test() {
		// List<Role> roles = rolerepo.findAll();
		// System.out.println(roles);
//		Role rol = this.rolerepo.findByRname("角色0");
//		Role r = new Role("超", true, 1, "用户", "普通管理", "nn", new Date(), "hhh", new Date());
//		rolerepo.save(r);
//		//创建并删除角色
//		rolerepo.delete(rolerepo.findByRname("超管"));
	System.out.println(rolerepo.findRoleMenus(1));
	}

}
