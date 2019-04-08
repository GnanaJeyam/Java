# REST API Using Spring Boot With MYSQL Database, and also configured with SPRING-CLOUD config server, Logger, Actuator, Swagger.

## Developing Levels of Rest API

 1. **Creating a controller that will perform simple CURD Operation.**

  RequestTypes :
	GET, POST, PUT, DELETE.

  Endpoints : 

	> GET -> http://localhost:9001/students	 
	   This EndPoint will return list of Students from Database.
	
	> GET with ID -> http://localhost:9001/students/{id}	 	
	   This EndPoint will return a specific student based on ID(Primary key).
				
	> POST -> http://localhost:9001/students
	   This EndPoint will add Student object to Table.
	   [Need to Pass required parameters in Request Body.]	 
	
	> PUT -> http://localhost:9001/students
	   This Endpoint will update the existing student from the Database.
	
	> DELETE -> http://localhost:9001/students/deleteStudent/{id}
	   This EndPoint will delete a specific student row object
	     from Database based on ID.

	###### REFER : com.example.springbackend.controller    
	
 2. **For CURD Operation we are using Spring JPA Repository.**
    We need to create Custom Interface and it should extend JPaRepository<Student[Object that need to persisted], Id<Primary Key DataType>> 
	
     	###### REFER : com.example.springbackend.repository

 3. **RestController should not talk directly to Repository layer.
    Instead of we are adding a Service Layer so that it will talk to Repository Layer.**

    The Service Layer Implementation class need to annotate with @service Annotation.
     
     	###### REFER : com.example.springbackend.service    
	
 4. **Service Layer should not Directly return the response from Database to Controller.
    Everytime we need to load the incoming response the dummy POJO object and it
    should pass to Controller.**
	
	###### REFER this class : com.example.springbackend.service.StudentInfo.java [Dummy POJO Object.]

 5. **Need to Handle Custom Exception if client sent bad request.
    Centralizing all exception handling part by using @ControllerAdvice Annotation.**
    
      	###### REFER : com.example.springbackend.exception

 6. **Adding a basic Authentication to Our REST Endpoint Using Spring Security.
    The Authentication class need to Annotate with @Configuration and it also need to extend 
	WebSecurityConfigurerAdapter.**

    To permit request request for some endpoint and to authenticate request for some endpoint
	we need to override protected void configure(HttpSecurity http) throws Exception this method
	from WebSecurityConfigurerAdapter class.
       
      Example : http.authorizeRequests()
		   .antMatchers("/health").permitAll()
		   .antMatchers("/students/{id}").permitAll()
		   .anyRequest()
		   .authenticated()
		   .and().csrf().disable()
		   .httpBasic();
	
	In the above code the url that contains /health and /students/{id} pattern will not be authenticated.
	   Remaining all other endpoints need to authentication.

 	###### REFER : com.example.springbackend.security

 7. **Adding Health Check endPoint to our REST API by using Spring-actuator.
     To Enable Actuator to our endPoint Just add that dependency in the pom.xml file.
     Remaining things will be automatically taken care by spring-boot.**

	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-actuator</artifactId>
	</dependency>


    	/auditevents -> lists security audit-related events such as user login/logout.
	
    	/health -> Will return the status of your application whether it is UP or DOWN. 

	/env -> will return the list of Systemproperties, Systemenvironment and applicationpropeties.
		Ex : JRE version, JVM vendor, JDK vendor, OS Name, and list of properties given in application.propeties file.
	
	/heapdump -> returns a heap dump from the JVM used by our application.
		    
	/info -> return information about custom data, build information or details about the latest commit
	
	/threaddump -> returns the thread dump of our JVM.
	
	/metrics -> Returns the JVM max and min memory. Instance Up time. Normal Threads and daemon threads available counts.  
		
		The primary and most useful response from metrics endpoints are gauge and counter.
		
		Guage -> Will return the total millisecs of a particular endpoint.
			Response time of specific endpoint.
		
			Example : 
			   After hitting this endpoint -> http://localhost:9001/students/
			     Gauge response in metrics will be like "gauge.response.students.root":14.0


		Counter -> will return the total no.of.hits in that endpoints with status code.
			
			Example : 
			   After hitting this endpoint -> http://localhost:9001/students/ 
			   Actually this endpoint needs authentication, so I'm hitting this 
				endpoints without request headers ( i.e, username and password )
				and with request headers.
			   
                           Finally the counter response in metrics will get two JSON keys.
				
				"counter.status.200.students.root":1,
				"counter.status.401.unmapped":1	
				
			   200 -> SUCCESS -> With Authentication.
			   401 -> UNAUTHORIZE -> Without Authentication.		

 8. **Adding Log4j2 logging API to our application.**
	
	###### Logging SEVERITY Example.
	
	CRITICAL/FATAL - The state that cause the application down or 
		the situation that may stop the application.

	ERROR -> Required when Application is failed due to some technical issue or some bug.
	         Someone need to fix it immediately.
	
	WARN -> Warn should be used when something bad happened, 
		but the application still has the chance to heal itself.
	
	INFO -> The INFO level should be used to document state changes in the 
		application or some entity within the application.
	
	ALERT -> Action must be taken immediately [but system is still usable].

	DEBUG -> Debug-level messages [i.e. messages logged for the sake of de-bugging)].

	TRACE -> Used when we want to log all information that helps us to trace the
		 processing of an incoming request through our application.
		 start and end of the processing of an incoming request or scheduled job.


9. **Added Spring Cloud Config server for Externalized Configuration. We need to have spring config-client
      so that our service will talk to config-server**

 	###### REFER this project for spring - config server 
	   [https://github.com/GnanaJeyam/Java/tree/master/springboot-configserver]
		
	In spring config server there are some profiling concepts. Main use of this profiling is we can have different     	    properties files based on environment like **dev,test,prod**. In the Spring config-server end we need to add 	 properties files based on this pattern:
	
	###### applicationname-profilename.yml or .properties
		
		Ex : test-dev.yml 
		    - test -> application-name.
		    - dev -> profile-name.
		    - .yml -> extension. It can also be .properties .


10. ** Enalbed Swagger REST API Documentation for our project.**
	
	###### REFER : com.example.springbackend.swagger


      	 	
