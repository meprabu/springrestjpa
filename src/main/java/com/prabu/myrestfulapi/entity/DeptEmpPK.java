package com.prabu.myrestfulapi.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the dept_emp database table.
 * 
 */
@Embeddable
public class DeptEmpPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int empNo;
	private String deptNo;

	public DeptEmpPK() {
	}

	@Column(name="emp_no", insertable=false, updatable=false)
	public int getEmpNo() {
		return this.empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	@Column(name="dept_no", insertable=false, updatable=false)
	public String getDeptNo() {
		return this.deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DeptEmpPK)) {
			return false;
		}
		DeptEmpPK castOther = (DeptEmpPK)other;
		return 
			(this.empNo == castOther.empNo)
			&& this.deptNo.equals(castOther.deptNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.empNo;
		hash = hash * prime + this.deptNo.hashCode();
		
		return hash;
	}
}