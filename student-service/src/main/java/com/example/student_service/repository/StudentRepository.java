package com.example.student_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student_service.dao.Student;


// JPA automatically makes all the necessary functions on it's own. HELL YEAHHHH!!!!
public interface StudentRepository extends JpaRepository<Student, Long> {

}
