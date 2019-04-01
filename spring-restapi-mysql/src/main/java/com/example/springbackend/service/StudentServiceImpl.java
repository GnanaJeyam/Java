package com.example.springbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbackend.Util.StudentUtil;
import com.example.springbackend.model.Student;
import com.example.springbackend.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<StudentInfo> getAllStudents() {
		
	  List<Student>	studentList = studentRepository.findAll();
	  
	  return StudentUtil.toStudentInfoList(studentList);
	}

	@Override
	public StudentInfo addStudent(Student std) {
		
		studentRepository.save(std);
		
		return StudentUtil.toStudentInfo(std);
	}

	@Override
	public boolean deleteStudent(String id) {

		if(null != id) {
			studentRepository.delete(id);
			return true;
		}
		
		return false;
	}

	@Override
	public StudentInfo findStudentById(String id) {

		Student std = studentRepository.findOne(id);
		   
		return StudentUtil.toStudentInfo(std);
	}

	@Override
	public StudentInfo updateStudent(Student student) {
		
		Student std =  studentRepository.findOne(student.getId());
		std.setId(student.getId());
		std.setName(student.getName());
		
		studentRepository.save(std);
		
		return StudentUtil.toStudentInfo(std);
	}

}
