package com.example.student_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student_service.dao.Student;
import com.example.student_service.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student student) {
        student.setId(id); // Set the ID of the new row to the ID value of the row that is to be replaced
        return studentRepository.save(student); // Overwrites the data in the other fields onto the entry;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
