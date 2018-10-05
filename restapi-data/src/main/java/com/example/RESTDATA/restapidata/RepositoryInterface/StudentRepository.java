package com.example.RESTDATA.restapidata.RepositoryInterface;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.RESTDATA.restapidata.Stdmodel.Student;

public interface StudentRepository extends MongoRepository<Student, String>{
	
}
