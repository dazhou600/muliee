package com.czg.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.czg.admin.dao.UserRepository;
import com.czg.admin.domain.Duty;


@Controller
public class AdminController {
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public ModelAndView admin() {
		List<Duty> dutys = this.userRepo.findAll();
		ModelAndView modelAndView = new ModelAndView("admin/sduty");
		modelAndView.addObject("dutys", dutys);
		System.out.println("***************/admin**************");

		return modelAndView;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		System.out.println("*****************************");

		return "login_reg";
	}
	
//	@RequestMapping(value="/loginform", method=RequestMethod.GET)
//	public String slogin(){
//		//System.out.println("*****************************");
//		return "admin/sduty";	
//	}
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView findUserByNamePasswd() {
		
		ModelAndView modelAndView = new ModelAndView("admin/sduty");
		return modelAndView;
	}
	
}
