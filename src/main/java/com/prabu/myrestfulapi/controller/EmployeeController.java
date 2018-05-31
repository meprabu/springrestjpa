package com.prabu.myrestfulapi.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prabu.myrestfulapi.entity.Department;
import com.prabu.myrestfulapi.entity.DeptManager;
import com.prabu.myrestfulapi.entity.Employee;
import com.prabu.myrestfulapi.error.GenericExceptionResponse;
import com.prabu.myrestfulapi.repository.DeptEmpRepository;
import com.prabu.myrestfulapi.repository.DeptManagerRepository;
import com.prabu.myrestfulapi.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class.getName());

	@Autowired
	EmployeeRepository employeeRepo;

	@Autowired
	DeptEmpRepository deptEmprepo;

	@Autowired
	DeptManagerRepository dedptManagerRepo;

	@RequestMapping(value = "/insertEmp", method = RequestMethod.POST)
	public ResponseEntity<Object> insertEmployee(@Valid @RequestBody Employee employee, Errors error) {

		logger.debug("in the method");
		// Employee e = getEmployee();
		if(error.hasErrors()){
			throw new RuntimeException();
		}
		if(Optional.ofNullable(employeeRepo.findById(employee.getEmpNo())).isPresent()){
			GenericExceptionResponse exceptionResponse = new GenericExceptionResponse(new Date(), "/insertEmp",
					"User already exsists");
			return new ResponseEntity<Object>(exceptionResponse, HttpStatus.CONFLICT);
		}else{
			employeeRepo.save(employee);
			HttpHeaders headers = getJsonContentHeaders("RespondedBy", "/insertEmp");
			return ResponseEntity.ok().headers(headers).body("User Inserted Successfully");
		}
	}

	@RequestMapping(value = "/getDepartmentEmployees/{deptno}", method = RequestMethod.GET)
	public ResponseEntity<List<Integer>> getDepartmentEmployees(@PathVariable("deptno") String deptno) {

		logger.debug("getDepartmentEmployees");

		Collection<Employee> empColl = deptEmprepo.getAllEmployeesforDepartment(deptno);

		List<Integer> empNumList = empColl.stream().map(s -> s.getEmpNo()).collect(Collectors.toList());

		HttpHeaders headers = getJsonContentHeaders("RespondedBy", "/getDepartmentEmployees");

		return ResponseEntity.ok().headers(headers).body(empNumList);
	}

	@RequestMapping("/getManager/{empno}")
	public ResponseEntity<List<Integer>> getManger(@PathVariable("empno") int empno) {

		logger.debug("in the method");
		List<Object[]> dms = dedptManagerRepo.getmanager(empno);
		List<Integer> empList = new ArrayList<Integer>();

		for (Object[] object : dms) {
			DeptManager dm = (DeptManager) object[0];
			Department d = (Department) object[1];
			empList.add(dm.getId().getEmpNo());
		}

		List<Integer> listEmp = dms.stream().map(s -> ((DeptManager) s[0]).getId().getEmpNo())
				.collect(Collectors.toList());

		HttpHeaders headers = getJsonContentHeaders("RespondedBy", "/getManager");

		return ResponseEntity.ok().headers(headers).body(listEmp);
	}

	private HttpHeaders getJsonContentHeaders(String respondedBy, String methodName) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		headers.add(respondedBy, methodName);
		return headers;
	}

	//bad! move to junit
	private Employee getEmployee() {
		Employee e = new Employee();
		LocalDate localDate = LocalDate.parse("1983-07-06");
		e.setBirthDate(java.sql.Date.valueOf(localDate));
		e.setFirstName("Prabu");
		e.setGender("M");
		localDate = LocalDate.parse("2014-07-06");
		e.setHireDate(java.sql.Date.valueOf(localDate));
		e.setEmpNo(2345509);
		e.setLastName("jayapandian");
		return e;
	}

}
