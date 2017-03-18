package com.czg.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.czg.admin.dao.UserRepository;
import com.czg.admin.domain.Duty;


@Controller
public class AdminController {
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/admin")
	public ModelAndView admin() {
		List<Duty> dutys = this.userRepo.findAll();
		ModelAndView modelAndView = new ModelAndView("admin/index");
		modelAndView.addObject("dutys", dutys);
		return modelAndView;
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("admin/login");
		return modelAndView;
	}
	
}
