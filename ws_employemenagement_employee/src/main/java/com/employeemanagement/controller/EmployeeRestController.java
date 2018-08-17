package com.employeemanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.entity.Company;
import com.employeemanagement.service.EmployeeService;

@RestController
public class EmployeeRestController {

	private EmployeeService employeeService;

	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/company")
	public ResponseEntity<Company> findByCompanyID(@RequestParam Integer companyID) {
		Company company = employeeService.findByCompanyID(companyID);
		return new ResponseEntity<Company>(company, HttpStatus.OK);
	}

	@PostMapping("/company")
	public ResponseEntity<String> saveCompany(@RequestBody Company company) {
		Company comp = employeeService.saveCompany(company);
		String result = comp != null ? "success" : "fail";
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

}
