package com.prabu.myrestfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prabu.myrestfulapi.entity.Department;
import com.prabu.myrestfulapi.entity.DeptManager;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	

	
	

}
