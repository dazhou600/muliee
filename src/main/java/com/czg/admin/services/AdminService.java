package com.czg.admin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czg.admin.dao.UserRepository;
import com.czg.admin.domain.Duty;
@Service
public class AdminService {
	@Autowired
	private UserRepository userDao;
	
	
}
