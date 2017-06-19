package com.keyholesoftware.apigateway.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.keyholesoftware.apigateway.api.employee.Employee;
import com.keyholesoftware.apigateway.api.employee.EmployeeService;
import com.keyholesoftware.apigateway.api.project.Project;
import com.keyholesoftware.apigateway.api.project.ProjectResource;
import com.keyholesoftware.apigateway.api.project.ProjectsClient;
import com.keyholesoftware.apigateway.api.userstory.UserStory;
import com.keyholesoftware.apigateway.api.userstory.UserStoryClient;

@RestController
public class Api {

	@Autowired
	private ProjectsClient projectsClient;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private UserStoryClient userStoryClient;

	@RequestMapping(method = RequestMethod.GET, value = "/api/projects/{id}/userstories", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Resources<UserStory>> userStoriesForProject(@PathVariable("id") Long id) {
		Resources<UserStory> stories = userStoryClient.getUserStories(id);
		return new ResponseEntity<Resources<UserStory>>(stories, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/projects/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Resource<Project>> project(@PathVariable("id") Long id) {
		Resource<Project> project = projectsClient.getProject(id);
		return new ResponseEntity<Resource<Project>>(project, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/api/projects", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Resource<Project>> createProject(@RequestBody Project project) {
		Resource<Project> createdProject = projectsClient.createProject(project);
		return new ResponseEntity<Resource<Project>>(createdProject, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/api/projects/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Resource<Project>> updateProject(@PathVariable("id") Long id, @RequestBody Project project) {
		Resource<Project> updatedProject = projectsClient.updateProject(id, project);
		return new ResponseEntity<Resource<Project>>(updatedProject, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/api/projects/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Object> deleteProject(@PathVariable("id") Long id) {
		projectsClient.deleteProject(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/projects", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Resources<Project>> projects(HttpServletRequest request) {
		Resources<Project> projects = projectsClient.getProjects();
		return new ResponseEntity<Resources<Project>>(projects, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/projects/{id}/resources", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Resources<ProjectResource>> projectResources(@PathVariable("id") Long id) {
		Resources<ProjectResource> resources = projectsClient.getProjectResources(id);
		for (ProjectResource projectResource : resources) {
			Employee employee = employeeService.findEmployee(projectResource.getEmployeeId());
			projectResource.setEmployee(employee);
		}
		return new ResponseEntity<Resources<ProjectResource>>(resources, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/api/projects/{id}/resources", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Resource<ProjectResource>> createProjectResource(@PathVariable("id") Long projectId,
			@RequestBody ProjectResource resource) {
		Resource<ProjectResource> createdResource = projectsClient.createProjectResource(projectId, resource);
		return new ResponseEntity<Resource<ProjectResource>>(createdResource, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/api/projects/{id}/resources/{resourceId}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Resource<ProjectResource>> updateProjectResource(@PathVariable("id") Long projectId,
			@PathVariable("resourceId") Long resourceId, @RequestBody ProjectResource resource) {
		Resource<ProjectResource> updatedResource = projectsClient.updateProjectResource(projectId, resourceId,
				resource);
		return new ResponseEntity<Resource<ProjectResource>>(updatedResource, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/api/projects/{projectId}/resources/{resourceId}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<ProjectResource> deleteProjectResource(@PathVariable("projectId") Long projectId,
			@PathVariable("resourceId") Long resourceId) {
		projectsClient.deleteProjectResource(projectId, resourceId);
		return new ResponseEntity<ProjectResource>(HttpStatus.OK);
	}
}
