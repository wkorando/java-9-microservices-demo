package com.keyholesoftware.apigateway.api.userstory;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign client interface to "userstory" service(s)
 */
@FeignClient("userstory")
public interface UserStoryClient {

	@RequestMapping(method = RequestMethod.GET, value = "/userStories/search/by-project", produces = "application/json", consumes = "application/json")
	Resources<UserStory> getUserStories(@RequestParam("projectId") Long id);
}