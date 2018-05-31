package com.prabu.myrestfulapi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.prabu.myrestfulapi.customAnnotations.ValidateEnum;
import com.prabu.myrestfulapi.enums.GENDER;
import com.prabu.myrestfulapi.utility.CustomJsonDateDeserializer;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name="employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Range(min = 0l, message = "Employee Number should be min of 2 digits")
	private Integer empNo;
	@NotNull
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private Date birthDate;
	@NotNull
	@Size(min=1, max=14, message="First Name cannot be more than 14 chars")
	private String firstName;
	@ValidateEnum(enumClass = GENDER.class, ignoreCase=true)
	private String gender;
	@NotNull
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private Date hireDate;
	@NotNull
	@Size(min=1, max=14, message="First Name cannot be more than 14 chars")
	private String lastName;
	private List<DeptEmp> deptEmps;
	private List<DeptManager> deptManagers;
	private List<Salary> salaries;
	private List<Title> titles;

	public Employee() {
	}


	@Id
	@Column(name="emp_no")
	public int getEmpNo() {
		return this.empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="birth_date")
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	@Column(name="first_name")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="hire_date")
	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}


	@Column(name="last_name")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	//bi-directional many-to-one association to DeptEmp
	@OneToMany(mappedBy="employee")
	public List<DeptEmp> getDeptEmps() {
		return this.deptEmps;
	}

	public void setDeptEmps(List<DeptEmp> deptEmps) {
		this.deptEmps = deptEmps;
	}

	public DeptEmp addDeptEmp(DeptEmp deptEmp) {
		getDeptEmps().add(deptEmp);
		deptEmp.setEmployee(this);

		return deptEmp;
	}

	public DeptEmp removeDeptEmp(DeptEmp deptEmp) {
		getDeptEmps().remove(deptEmp);
		deptEmp.setEmployee(null);

		return deptEmp;
	}


	//bi-directional many-to-one association to DeptManager
	@OneToMany(mappedBy="employee")
	public List<DeptManager> getDeptManagers() {
		return this.deptManagers;
	}

	public void setDeptManagers(List<DeptManager> deptManagers) {
		this.deptManagers = deptManagers;
	}

	public DeptManager addDeptManager(DeptManager deptManager) {
		getDeptManagers().add(deptManager);
		deptManager.setEmployee(this);

		return deptManager;
	}

	public DeptManager removeDeptManager(DeptManager deptManager) {
		getDeptManagers().remove(deptManager);
		deptManager.setEmployee(null);

		return deptManager;
	}


	//bi-directional many-to-one association to Salary
	@OneToMany(mappedBy="employee")
	public List<Salary> getSalaries() {
		return this.salaries;
	}

	public void setSalaries(List<Salary> salaries) {
		this.salaries = salaries;
	}

	public Salary addSalary(Salary salary) {
		getSalaries().add(salary);
		salary.setEmployee(this);

		return salary;
	}

	public Salary removeSalary(Salary salary) {
		getSalaries().remove(salary);
		salary.setEmployee(null);

		return salary;
	}


	//bi-directional many-to-one association to Title
	@OneToMany(mappedBy="employee")
	public List<Title> getTitles() {
		return this.titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}

	public Title addTitle(Title title) {
		getTitles().add(title);
		title.setEmployee(this);

		return title;
	}

	public Title removeTitle(Title title) {
		getTitles().remove(title);
		title.setEmployee(null);

		return title;
	}

}