package com.keyholesoftware.userstory.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface UserStoryRepository extends PagingAndSortingRepository<UserStory, Long> {
	@RestResource(path = "by-project")
	Iterable<UserStory> findByProjectId(@Param("projectId") Long projectId);
}
