package com.czg.admin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czg.admin.dao.DutyRepository;

import com.czg.admin.domain.Duty;
@Service
public class AdminService {
	@Autowired
	private DutyRepository userDao;
	
	public List<Duty> findAll(){
	return userDao.findAll();	
	}
}
