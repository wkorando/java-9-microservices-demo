package com.keyholesoftware.apigateway.api.project;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Feign client interface to "projects" service(s)
 * 
 * @author James.Niswonger
 */
@FeignClient("projects")
public interface ProjectsClient {

	@RequestMapping(method = RequestMethod.GET, value = "/projects", produces = "application/json", consumes = "application/json")
	Resources<Project> getProjects();

	@RequestMapping(method = RequestMethod.GET, value = "/projects/{id}", produces = "application/json", consumes = "application/json")
	Resource<Project> getProject(@PathVariable("id") Long id);

	@RequestMapping(method = RequestMethod.POST, value = "/projects", produces = "application/json", consumes = "application/json")
	Resource<Project> createProject(@RequestBody Project project);

	@RequestMapping(method = RequestMethod.PUT, value = "/projects/{id}", produces = "application/json", consumes = "application/json")
	Resource<Project> updateProject(@PathVariable("id") Long id, @RequestBody Project project);

	@RequestMapping(method = RequestMethod.DELETE, value = "/projects/{id}", produces = "application/json", consumes = "application/json")
	void deleteProject(@PathVariable("id") Long id);

	@RequestMapping(method = RequestMethod.GET, value = "/projects/{id}/resources", produces = "application/json", consumes = "application/json")
	Resources<ProjectResource> getProjectResources(@PathVariable("id") Long projectId);

	@RequestMapping(method = RequestMethod.POST, value = "/projects/{id}/resources", produces = "application/json", consumes = "application/json")
	Resource<ProjectResource> createProjectResource(@PathVariable("id") Long id, @RequestBody ProjectResource projectResource);

	@RequestMapping(method = RequestMethod.PUT, value = "/projects/{id}/resources/{resourceId}", produces = "application/json", consumes = "application/json")
	Resource<ProjectResource> updateProjectResource(@PathVariable("id") Long id, @PathVariable("resourceId") Long resourceId, @RequestBody ProjectResource projectResource);

	@RequestMapping(method = RequestMethod.DELETE, value = "/projects/{id}/resources/{resourceId}", produces = "application/json", consumes = "application/json")
	Resource<ProjectResource> deleteProjectResource(@PathVariable("id") Long id, @PathVariable("resourceId") Long resourceId);
}