package com.example.RESTDATA.restapidata.studentController;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.RESTDATA.restapidata.RepositoryInterface.StudentRepository;
import com.example.RESTDATA.restapidata.Stdmodel.Student;

@RestController
public class StudentRestController {
	
	@Autowired
	StudentRepository stdrep ;
	
	@RequestMapping(value = "/getStudents", method = RequestMethod.GET)
	public List<Student> getAllStudents(){
		
		return stdrep.findAll();
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public void addStudent(@RequestBody Student st) {
		
		st.setId(ObjectId.get());
		
		stdrep.save(st);
	}
	
	@RequestMapping(value = "/deleteStudent/{id}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable ObjectId id) {
		
		//stdrep.delete(stdrep.findById(arg0));
	}
}
