# khs-project-service 
-------------------

Description
-----------
Provides bounded context API for Projects 

Installation
------------

1. Clone this repository
2. Import into an IDE and configure it as a Maven project
3. Start server by running the `com.keyolesoftware.projects.ProjectsApp` as a Java Application

Discovery Server Configuration
-------------------------------
By default, the service registers with a `localhost` Eureka-based registry

API
---
     /projects           | GET    | returns all Projects
     /projects/{id}      | GET    | returns a specific Project by 'id'
     /projects           | POST   | add a new Project 
     /projects/{id}      | PUT    | update a Project
     /projects/{id}      | DELETE | deletes a Project
