package com.keyholesoftware.apigateway.api.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class EmployeeService {

	@Autowired
	private EmployeesClient employeesClient;

	public Iterable<Employee> all() {
		return employeesClient.all();
	}

	@HystrixCommand(fallbackMethod = "handleEmployeeFailure")
	public Employee findEmployee(Long id) {
		return employeesClient.getEmployee(id);
	}

	@SuppressWarnings("unused")
	private Employee handleEmployeeFailure(Long id) {
		Employee employee = new Employee();
		employee.setId(id);
		employee.setFirstname("Unknown");
		employee.setLastname("Unknown");
		employee.setEmail("Unknown");
		return employee;
	}
}
