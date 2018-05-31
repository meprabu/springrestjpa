package com.prabu.myrestfulapi.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prabu.myrestfulapi.entity.DeptManager;
import com.prabu.myrestfulapi.entity.DeptManagerPK;
import com.prabu.myrestfulapi.entity.Employee;


@Repository
public interface DeptManagerRepository extends JpaRepository<DeptManager, DeptManagerPK>{

	String GET_MANAGER = " from DeptManager as dm INNER JOIN dm.department as dept INNER JOIN dept.deptEmps as emp where emp.employee.empNo= ?#{[0]}";
	
//	String GET_MANAGER = " from Employee emp INNER JOIN emp.deptEmps depEmp where depEmp.department.deptNo = ?#{[0]}";
	
	@Query(GET_MANAGER)
	List<Object[]> getmanager(int empno);
	
}

