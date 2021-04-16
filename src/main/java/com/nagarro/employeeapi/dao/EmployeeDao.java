/*
* Class name: EmployeeDao
*
* Version info: jdk 1.8
*
* Copyright notice:
* 
* Author info: Arpit Garg
*
* Creation date: 13/Apr/2021
*
* Last updated By: Arpit Garg
*
* Last updated Date: 16/Apr/2021
*
* Description: Employee database request handler
*/
package com.nagarro.employeeapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.employeeapi.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
