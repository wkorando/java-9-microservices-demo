package com.keyholesoftware.projects.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jaime Niswonger
 */
@Entity
public class Project {

	@Id
	@GeneratedValue
	Long id;

	private String name;
	private String description;
	private double hours;
	private double budget;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public Collection<ProjectResource> getResources() {
		return resources;
	}

	public void setResources(Collection<ProjectResource> resources) {
		this.resources = resources;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "project")
	private Collection<ProjectResource> resources;

	@JsonProperty(value = "resources")
	public int getResourceCount() {
		return this.resources != null ? this.resources.size() : 0;
	}
}
