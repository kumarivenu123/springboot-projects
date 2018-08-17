package com.spring.batch;

import org.springframework.batch.item.ItemProcessor;

import com.spring.batch.entity.Employee;

public class MyProcessor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee employee) throws Exception {
		System.out.println(employee.toString());
		return null;
	}

}
