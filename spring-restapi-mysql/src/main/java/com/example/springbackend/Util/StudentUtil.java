package com.example.springbackend.Util;

import java.util.ArrayList;
import java.util.List;

import com.example.springbackend.model.Student;
import com.example.springbackend.service.StudentInfo;

public class StudentUtil {

	private StudentUtil() {
		
	}
	
	public static StudentInfo toStudentInfo(Student std) {
		
		StudentInfo stdWrap = new StudentInfo();
		   stdWrap.setId(std.getId());
		   stdWrap.setName(std.getName());
		
		
		return stdWrap;
	}
	
	public static List<StudentInfo> toStudentInfoList(List<Student> studentList) {

		List<StudentInfo> studentWrappers = new ArrayList<>();

		  studentList.forEach(student -> {
			  StudentInfo studentTemp = new StudentInfo();
			  studentTemp.setId(student.getId());
			  studentTemp.setName(student.getName());
			  studentWrappers.add(studentTemp);
		  });
		  
		return studentWrappers;
	}
}
