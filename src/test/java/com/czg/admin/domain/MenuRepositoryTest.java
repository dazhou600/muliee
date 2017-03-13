package com.czg.admin.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.czg.admin.dao.MenuRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuRepositoryTest {

	@Autowired
	private MenuRepository menurepo;

	@Test
	public void test() {
		//List<Menu> menus = menurepo.findAll() ;
		//System.out.println(menus);
	}

}
