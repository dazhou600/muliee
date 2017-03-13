package com.czg.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czg.admin.domain.Duty;
import com.czg.admin.services.AdminService;


@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	@RequestMapping("/admin")
	public String admin(Model model) {
		//model.addAttribute("dutys",adminService.findAll());
		return "admin/index";
	}
	
}
