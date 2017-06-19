# khs-employee-service 
------------------- 


Description
-----------
Provides bounded context API for Employees 

Installation
------------

1. Clone this repository
2. Import the project into an IDE and configure it as a Maven project
3. Start server by running the `com.keyolesoftware.employees.EmployeesApp` as a Java Application

Discovery Server Configuration
-------------------------------
By default, the service registers with a `localhost` Eureka-based registry

API
---
     /employees           | GET    | returns all Employees
     /employees/{id}      | GET    | returns a specific Employee by 'id'
     /employees           | POST   | add a new Employee 
     /employees/{id}      | PUT    | update an Employee
     /employees/{id}      | DELETE | deletes an Employee
