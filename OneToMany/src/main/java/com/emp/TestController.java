package com.emp;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
public class TestController {

	@Autowired
	private CompanyRepository companyRepository;

	@GetMapping("/")
	public Company test() {
		Company company = new Company();
		company.setCompanyName("CTS");

		Employee emp1 = new Employee();
		emp1.setEmpName("venu");

		Employee emp2 = new Employee();
		emp2.setEmpName("rama");

		Set<Employee> emps = new HashSet<>();
		emps.add(emp1);
		emps.add(emp2);
		company.setEmployees(emps);
		return companyRepository.save(company);
	}

}

@Entity
@Table(name = "COMPANY")
@Data
class Company implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer companyId;
	private String companyName;
	@OneToMany(targetEntity = Employee.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "CompanyId", referencedColumnName = "companyId")
	private Set<Employee> employees;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(Integer companyId, String companyName, Set<Employee> employees) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.employees = employees;
	}

}

@Entity
@Table
@Data
class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeId;
	private String empName;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer employeeId, String empName) {
		super();
		this.employeeId = employeeId;
		this.empName = empName;
	}

}

@Repository
interface CompanyRepository extends JpaRepository<Company, Integer> {

}

@Repository
interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
