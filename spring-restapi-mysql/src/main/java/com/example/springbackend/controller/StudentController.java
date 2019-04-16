package com.example.springbackend.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbackend.exception.InvalidRequestTypeException;
import com.example.springbackend.model.Student;
import com.example.springbackend.service.StudentInfo;
import com.example.springbackend.service.StudentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RefreshScope
@RequestMapping("/students")
public class StudentController {
	
	private static final Logger log = LogManager.getLogger(StudentController.class);
	
	/* Reading values from application-profile.yml file
	 * which is located in spring config server.*/	
	@Value("${message: Default Message}")
	private String message;
	
	private StudentService studentService;
	@Autowired
	public StudentController(StudentService studentServiceImpl) {
		
		this.studentService = studentServiceImpl;
	}
	/*Testing end Point to fetch value from the yml located in spring config server.*/
	@ApiOperation(value = "Testing Endpoint to read the file from Spring config server.",
		    notes = "Testing end Point to fetch value from the yml located in spring config server.")
	@GetMapping("/greet")
	public String getMessage() {
		
		return message;
	}
	
	@ApiOperation(value = "Return all the students from the Database.",
		    notes = "Will return All the Student object from the DB using GET request.")
	@GetMapping()
	public List<StudentInfo> getAllStudents() {
		
		log.trace("Retriving Student records from Databases.!");
		
		return studentService.getAllStudents();
	}
	@ApiOperation(value = "Find student by id",
		    notes = "Will return the Student object based on request Id.")
	@GetMapping("/{id}")
	public StudentInfo getStudentById(@PathVariable String id) {
		
		log.info( " Retriving record for this ID -> "+id);

		if(!id.matches("([A-z0-9]{3,}\\-){4}[A-z0-9]{3,}"))
		{	
			log.error("Bad Request received..!");

			throw new InvalidRequestTypeException("Invalid Request Sent");
		}
		
		return studentService.findStudentById(id);
	}
	
	@ApiOperation(value = "Add new student object to the database.",
		    notes = "Will store the Student object to the database using POST request.")
	@PostMapping()
	public StudentInfo addStudent(@RequestBody Student std) {
		
		log.info("Adding Student record to the table");
		
		return studentService.addStudent(std);
	}
	
	@ApiOperation(value = "Update the Existing Student in the DB.",
		    notes = "Update the existing student object with new value in the database using PUT request.")
	@PutMapping()
	public StudentInfo updateStudent(@RequestBody Student std) {
		
		log.info("Updating Student record for this Id ->"+std.getId());
		
		return studentService.updateStudent( std );
	}
	
	@ApiOperation(value = "Delete the Student object from the DB.",
		    notes = "Delete the student object based on id from the database using DELETE request.")
	@DeleteMapping("/deleteStudent/{id}")
	public Boolean deleteStudent(@PathVariable String id) {
		
		log.info("Deleting Student record for this Id ->"+id);
		
		return studentService.deleteStudent(id);
	}
}
