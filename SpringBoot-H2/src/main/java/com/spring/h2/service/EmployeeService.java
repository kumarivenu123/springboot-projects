package com.spring.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.h2.entity.Employee;
import com.spring.h2.entity.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public String addEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		return emp != null ? "Employee Added" : "Employee Not Added";
	}

	public Employee fetchEmployee(Integer employeeID) {
		return employeeRepository.findOne(employeeID);
	}

	public List<Employee> fetchAllEmployees() {
		return employeeRepository.findAll();
	}

	public String updateEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		return emp != null ? "Employee Updated" : "Employee Not Updated";
	}

}
