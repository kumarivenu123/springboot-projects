package com.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeemanagement.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
