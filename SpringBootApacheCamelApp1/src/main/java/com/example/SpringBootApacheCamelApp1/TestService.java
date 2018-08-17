package com.example.SpringBootApacheCamelApp1;

import org.springframework.stereotype.Service;

@Service
public class TestService {

	public void setEmployeId(Employee employee) {
		employee.setEmpId(1332);
	}
}
