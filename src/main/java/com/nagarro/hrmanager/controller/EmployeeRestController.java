package com.nagarro.hrmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.hrmanager.dao.EmployeeDao;
import com.nagarro.hrmanager.model.Employee;
import com.nagarro.hrmanager.repo.EmployeeRepo;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	EmployeeRepo repo;
	
	@Autowired
	EmployeeDao employeedao;
	
	@GetMapping("/Employee")
	public List<Employee> findAll(){
		return repo.findAll();
	}
	
	@PostMapping(path="/Employee")
	public Employee addEmployee(@RequestBody Employee emp) {
		repo.save(emp);
		return emp;
	}
	@PutMapping("/Employee")
	public Employee updateEmployee(@RequestBody Employee emp) {
		repo.save(emp);
		return emp;
	}
	
	@GetMapping("/Employee/{employeeCode}")
	public Employee getEmployeeByID(@PathVariable int employeeCode){
		
		Employee emp = repo.findById(employeeCode).orElseThrow(RuntimeException::new);
		
//		if(emp == null) 
//			throw new RuntimeException("No Employee found for this" +employeeCode +"(Emplyocode)");

		return emp;
	}
	
	@Transactional
	@DeleteMapping("/Employee/{employeeCode}")
	public String deleteEmployee(@PathVariable int employeeCode) {
		Employee emp= repo.getById(employeeCode);
		if(emp == null)
			throw new RuntimeException("No Employee found for this" +employeeCode +"(Employeecode)");
		employeedao.deleteById(employeeCode);
		return "Employee Deleted with code: "+employeeCode ;
	}
}
