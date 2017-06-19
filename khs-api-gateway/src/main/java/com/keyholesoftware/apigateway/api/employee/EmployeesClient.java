package com.keyholesoftware.apigateway.api.employee;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Feign client interface to "employees" service(s)
 * 
 * @author James.Niswonger
 */
@FeignClient("employees")
public interface EmployeesClient {

	@RequestMapping(method = RequestMethod.GET, value = "/employees")
	Iterable<Employee> all();

	@RequestMapping(method = RequestMethod.GET, value = "/employees/{id}", produces = "application/json", consumes = "application/json")
	Employee getEmployee(@PathVariable("id") Long id);
}