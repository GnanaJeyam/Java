package com.example.springbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbackend.model.Student;

public interface StudentRepository extends JpaRepository<Student, String>{

}
