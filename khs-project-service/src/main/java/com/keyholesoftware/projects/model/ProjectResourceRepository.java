package com.keyholesoftware.projects.model;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * @author Jaime Niswonger
 */
@RepositoryRestResource
public interface ProjectResourceRepository extends PagingAndSortingRepository<ProjectResource, Long> {

	@RestResource(path = "by-project")
	public Iterable<ProjectResource> findByProjectId(@Param("projectId") Long projectId);

	@Modifying
	@Transactional
	@RestResource(path = "delete-by-employee-id")
	@Query(value = "delete from ProjectResource pr where pr.employeeId = ?1")
	public void deleteByEmployeeId(@Param("employeeId") Long employeeId);
}
