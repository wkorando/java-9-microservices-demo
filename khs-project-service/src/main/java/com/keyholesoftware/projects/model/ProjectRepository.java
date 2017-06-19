package com.keyholesoftware.projects.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Jaime Niswonger
 */
@RepositoryRestResource
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
}
