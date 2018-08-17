package com.spring.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.h2.entity.Employee;
import com.spring.h2.service.EmployeeService;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		for(int i=1; i<10; i++) {
			System.out.println(i);
		}
		String status = employeeService.addEmployee(employee);
		return new ResponseEntity<String>(status, HttpStatus.CREATED);
	}

	@GetMapping("/fetch")
	public ResponseEntity<Employee> fetchEmployee(@RequestParam Integer employeeID) {
		Employee employee = employeeService.fetchEmployee(employeeID);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@GetMapping("/fetch/all")
	public ResponseEntity<List<Employee>> fetchAllEmployee() {
		List<Employee> employees = employeeService.fetchAllEmployees();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		String status = employeeService.updateEmployee(employee);
		return new ResponseEntity<String>(status, HttpStatus.CREATED);
	}

}
