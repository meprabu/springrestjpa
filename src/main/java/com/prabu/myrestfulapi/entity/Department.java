package com.prabu.myrestfulapi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departments database table.
 * 
 */
@Entity
@Table(name="departments")
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;
	private String deptNo;
	private String deptName;
	private List<DeptEmp> deptEmps;
	private List<DeptManager> deptManagers;

	public Department() {
	}


	@Id
	@Column(name="dept_no")
	public String getDeptNo() {
		return this.deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}


	@Column(name="dept_name")
	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	//bi-directional many-to-one association to DeptEmp
	@OneToMany(mappedBy="department", cascade={CascadeType.ALL})
	public List<DeptEmp> getDeptEmps() {
		return this.deptEmps;
	}

	public void setDeptEmps(List<DeptEmp> deptEmps) {
		this.deptEmps = deptEmps;
	}

	public DeptEmp addDeptEmp(DeptEmp deptEmp) {
		getDeptEmps().add(deptEmp);
		deptEmp.setDepartment(this);

		return deptEmp;
	}

	public DeptEmp removeDeptEmp(DeptEmp deptEmp) {
		getDeptEmps().remove(deptEmp);
		deptEmp.setDepartment(null);

		return deptEmp;
	}


	//bi-directional many-to-one association to DeptManager
	@OneToMany(mappedBy="department")
	public List<DeptManager> getDeptManagers() {
		return this.deptManagers;
	}

	public void setDeptManagers(List<DeptManager> deptManagers) {
		this.deptManagers = deptManagers;
	}

	public DeptManager addDeptManager(DeptManager deptManager) {
		getDeptManagers().add(deptManager);
		deptManager.setDepartment(this);

		return deptManager;
	}

	public DeptManager removeDeptManager(DeptManager deptManager) {
		getDeptManagers().remove(deptManager);
		deptManager.setDepartment(null);

		return deptManager;
	}

}