package com.example.springbackend.service;

import java.util.List;

import com.example.springbackend.model.Student;

public interface StudentService {
	
	List<StudentInfo> getAllStudents();
	
	StudentInfo addStudent(Student std);
	
	StudentInfo updateStudent(Student student);
	
	StudentInfo findStudentById(String id);

	boolean deleteStudent(String id);
}
