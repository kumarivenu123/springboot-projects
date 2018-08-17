package com.employeemanagement.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer companyID;

	private String companyName;

	@OneToMany(targetEntity = Employee.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "companyID", referencedColumnName = "companyID")
	private List<Employee> employees;

	public Integer getCompanyID() {
		return companyID;
	}

	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Company() {
	}

	public Company(Integer companyID, String companyName, List<Employee> employees) {
		this.companyID = companyID;
		this.companyName = companyName;
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Company [companyID=" + companyID + ", companyName=" + companyName + ", employees=" + employees + "]";
	}

}
