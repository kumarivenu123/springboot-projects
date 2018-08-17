package com.employeemanagement.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employeemanagement.entity.Company;
import com.employeemanagement.repository.CompanyRepository;

@Service
public class EmployeeService {

	private CompanyRepository companyRepository;

	public EmployeeService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	public Company findByCompanyID(Integer companyID) {
		Optional<Company> company = companyRepository.findById(companyID);
		return company.get();
	}

	public Company saveCompany(Company company) {
		Company comp = companyRepository.save(company);
		return comp;
	}

}
