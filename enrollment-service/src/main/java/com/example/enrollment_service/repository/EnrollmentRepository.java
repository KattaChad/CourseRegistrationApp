package com.example.enrollment_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.enrollment_service.dao.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudentId(String student_id);

    List<Enrollment> findByCourseCode(String course_code);    
}
