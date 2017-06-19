package com.keyholesoftware.employees.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Employee Repository
 * 
 */
@RepositoryRestResource
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
}
