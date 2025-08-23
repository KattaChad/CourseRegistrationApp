package com.example.course_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course_service.dao.Course;
import com.example.course_service.repository.CourseRepository;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public List<Course> getCourseByCourseCode(String course_code) {
        return courseRepository.findBySubjectCode(course_code);
    }

    public Course updateCourse(Long id, Course course) {
        course.setCourseId(id);
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
