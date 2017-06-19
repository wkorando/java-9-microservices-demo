# khs-project-ui-service
Project AngularJS UI

This Spring Boot application provides a simple AngularJS UI for a reference Project Management tool. It is backed by a reference Microservices implementation.

Installation 
------------

1. Clone this repository locally 
2. Import into an IDE and configure it as a Maven Project (Also, you must import the projects listed below)
3. Run as a `com.keyholesoftware.project.ui.Application` as a Java Application
4. Configure and run the required projects shown below
5. Open a browser and access `http://localhost:8080`

**NOTE:** The following projects are needed to support the running application, follow the links below to get the **--required--** services running:

#### Discovery Server
[khs-eureka](https://github.com/in-the-keyhole/khs-eureka)  **-- required --**

#### Edge Server - Routing and Authentication
[khs-zuul](https://github.com/in-the-keyhole/khs-zuul) **--required--**

#### API Gateway
[khs-api-gateway](https://github.com/in-the-keyhole/khs-api-gateway) **--required--**

#### Project Service - Project 'Microservice' implementation
[khs-project-service](https://github.com/in-the-keyhole/khs-project-service) **--required--**

#### Employee Service - Employee 'Microservice' implementation
[khs-employee-service](https://github.com/in-the-keyhole/khs-employee-service) **--required--**

#### Hystrix Circuit Breaker Dashboard
[khs-hystrix-dashboard](https://github.com/in-the-keyhole/khs-hystrix-dashboard) --optional--

#### Messaging Broker
[khs-kafka](https://github.com/in-the-keyhole/khs-kafka)  -- optional --

