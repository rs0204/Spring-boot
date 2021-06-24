package com.nagarro.hrmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.hrmanager.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	
}
