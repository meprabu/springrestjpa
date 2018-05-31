package com.prabu.myrestfulapi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the salaries database table.
 * 
 */
@Entity
@Table(name="salaries")
@NamedQuery(name="Salary.findAll", query="SELECT s FROM Salary s")
public class Salary implements Serializable {
	private static final long serialVersionUID = 1L;
	private SalaryPK id;
	private int salary;
	private Date toDate;
	private Employee employee;

	public Salary() {
	}


	@EmbeddedId
	public SalaryPK getId() {
		return this.id;
	}

	public void setId(SalaryPK id) {
		this.id = id;
	}


	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="to_date")
	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
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