package com.keyholesoftware.apigateway.api.project;

import com.keyholesoftware.apigateway.api.employee.Employee;

public class ProjectResource {

	private Long id;

	private String role;
	private double manhours;

	private Long employeeId;

	private Employee employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getManhours() {
		return manhours;
	}

	public void setManhours(double manhours) {
		this.manhours = manhours;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
