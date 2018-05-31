package com.prabu.myrestfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prabu.myrestfulapi.entity.Salary;
import com.prabu.myrestfulapi.entity.SalaryPK;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, SalaryPK>{

}
