package com.prabu.myrestfulapi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the dept_emp database table.
 * 
 */
@Entity
@Table(name="dept_emp")
@NamedQuery(name="DeptEmp.findAll", query="SELECT d FROM DeptEmp d")
public class DeptEmp implements Serializable {
	private static final long serialVersionUID = 1L;
	private DeptEmpPK id;
	private Date fromDate;
	private Date toDate;
	private Department department;
	private Employee employee;

	public DeptEmp() {
	}


	@EmbeddedId
	public DeptEmpPK getId() {
		return this.id;
	}

	public void setId(DeptEmpPK id) {
		this.id = id;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="from_date")
	public Date getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="to_date")
	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}


	//bi-directional many-to-one association to Department
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dept_no", insertable=false, updatable=false)
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}


	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="emp_no", insertable=false, updatable=false)
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}