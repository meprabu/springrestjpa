package com.prabu.myrestfulapi.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prabu.myrestfulapi.entity.Department;
import com.prabu.myrestfulapi.entity.DeptEmp;
import com.prabu.myrestfulapi.entity.DeptEmpPK;
import com.prabu.myrestfulapi.entity.Employee;


@Repository
public interface DeptEmpRepository extends JpaRepository<DeptEmp, DeptEmpPK>{
	
	String GET_EMP_FOR_DEPT = " from Employee emp INNER JOIN emp.deptEmps depEmp where depEmp.department.deptNo = ?#{[0]}";
	
	@Query(GET_EMP_FOR_DEPT)
	Collection<Employee> getAllEmployeesforDepartment(String deptno);

}
