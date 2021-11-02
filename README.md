# micro-start
Start Up(Microservice) Project Using Java,Spring-boot


### Simple Modules

1) Admission
2) Doctor
3) Patient


### Architechture

* Eureka
* Gateway
* Hystrix
* Hystrix-Dashboard
* API (resources)
* Config Server (later)


***Perdon me for mistakes(if any)

### Strategy
* Start Eureka-Boss Service
* Then Gateway service
* Then Admission,Doctor,Patient, Hystrix-Dashboard
* LoadBalanced (Implemented before ResTemplate, also in Gateway .yml file [lb] )
* Try to access:  http://localhost:8989/admission/allDoctors (8989 for Gateway, URI for accessing Doctors from Admission)
* Dynamic CircuitBreaker pattern added for Admission (as it has Internal API call), also exposed actuator End-point for Hystrix-Dashboard
* For Dashboard: http://localhost:9191/hystrix , then copy target URI (http://localhost:8083/actuator/hystrix.stream) and Hit Monitor Button
