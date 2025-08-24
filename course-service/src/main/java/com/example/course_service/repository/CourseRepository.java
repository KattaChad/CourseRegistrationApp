package com.example.course_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course_service.dao.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findBySubjectCode(String course_code);

    boolean existsBySubjectCode(String course_code);
}
