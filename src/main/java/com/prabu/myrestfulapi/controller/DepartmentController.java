package com.prabu.myrestfulapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prabu.myrestfulapi.entity.Department;
import com.prabu.myrestfulapi.repository.DepartmentRepository;

@RestController
public class DepartmentController {
	
	
	
	@Autowired
	DepartmentRepository departmentRepo;
	
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class.getName());
	
	@RequestMapping("/insertDept")
	public void insertDept(){
		
		logger.debug("in the method");
		
		Department d = new Department();
		d.setDeptNo("777");
		d.setDeptName("Lazy Department");
		departmentRepo.save(d);
	}
	

}
