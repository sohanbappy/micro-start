# micro-start
Developing Microservice Project(Doctor-Appoinment) Using Spring-boot


### Simple Modules

1) Admission
2) Doctor
3) Patient

### Try to find out Answers
* Why Micro-service?
* Why API-Gateway needed?
* Fine, But why config-server?
* Is it necessery to use Hystrix Dashboard?

### Architechture

* Eureka
* Gateway
* Hystrix
* Hystrix-Dashboard
* API (resources)
* Config Server


***Perdon me for mistakes(if any)

### Strategy
* Start Eureka-Boss Service
* Then Config-Server, Gateway service
* Then Admission,Doctor,Patient, Hystrix-Dashboard
* LoadBalanced (Implemented before ResTemplate, also in Gateway .yml file [lb] )
* Try to access:  http://localhost:8989/admission/allDoctors (8989 for Gateway, URI for accessing Doctors from Admission)
* Dynamic CircuitBreaker pattern added for Admission (as it has Internal API call), also exposed actuator End-point for Hystrix-Dashboard
* For Dashboard: http://localhost:9191/hystrix , then copy target URI (http://localhost:8083/actuator/hystrix.stream) and Hit Monitor Button

### Config-server?? What is that??
* Change EndPoint, Values without making any changes in code..Cool
* No need to repeat same Comfig for all resources over micro-services
* Remember (add a repo, add dependencies, point to config-server uri in bootstrap.yml file)

### Challenges
* @Value for reading value from Config-server
