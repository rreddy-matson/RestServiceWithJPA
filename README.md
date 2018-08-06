# Vehicle Demo 
Demo Rest services to handle CRUD operation on vehicles

###  Design
Built as a Spring Boot web application. 
* Builds simple APIs (GET,POST,PUt and DELETE) to handle operations.
*Mapped Services
	* Get vehicles list
		http://localhost:8080/vehicleDemo/vehicle ,method=GET
	* Get vehicle by id
		http://localhost:8080/vehicleDemo/vehicle/{id} ,method=GET
	* Get vehicles list by given vehicle type
		http://localhost:8080/vehicleDemo/vehicle/type/{vehicleType}] method=GET 
	* Create new vehicle
		http://localhost:8080/vehicleDemo/vehicle method=POST consumes=[application/json]
	* Delete vehicle for given id
		http://localhost:8080/vehicleDemo/vehicle/{id} method=DELETE
	* Get vehicles list by given vehicle medium of transport
		http://localhost:8080/vehicleDemo/vehicle/transportMedium/{mediumOfTransport} method=GET
	* Update vehicle details 
		http://localhost:8080/vehicleDemo/vehicle ,method=[PUT],consumes=[application/json]
* Future implementation to add Swagger UI and docs 	
#### Technologies
* Spring Boot - http://projects.spring.io/spring-boot/

### Getting started
* build the application
    * mvn clean build 
* Deploy the vehicleDemo.war on tomcat under directory `<apache-tomcat-install>/webapps`
	 * run startup in bin 
### Other References:
* 