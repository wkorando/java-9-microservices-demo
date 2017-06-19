package com.keyholesoftware.employees.model;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;


/**
 * REST configuration class for Employee. 
 * @author williamkorando
 *
 */
@Configuration
public class EmployeeRepositoryRestMvcConfiguration extends RepositoryRestMvcConfiguration {

	@Override
	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Employee.class);
	}
}