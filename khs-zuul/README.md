# khs-zuul

A reference Zuul implementation - supporting out Microservice Reference Application

This edge router will route all /api traffic to the 'api-gateway' resource found in Eureka and all other traffic to the 'project-ui' resource found in Eureka

```
  routes:
      api:
        path: /api/**
        serviceId: api-gateway
        stripPrefix: false
      static:
        path: /**
        serviceId: project-ui
```

Installation
------------

1. Clone this repository
2. Import into an IDE and configure it as a Maven Project
3. Start server by running the `com.keyolesoftware.zuul.ZuulServer` as a Java Application
