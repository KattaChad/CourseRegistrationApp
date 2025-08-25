package com.example.enrollment_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.enrollment_service.dao.Enrollment;
import com.example.enrollment_service.service.CourseAddService;

@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentController {
    private final CourseAddService courseAddService;

    public EnrollmentController(CourseAddService courseAddService) {
        this.courseAddService = courseAddService;
    }

    @GetMapping("/courses")
    public Object fetchCourses() {
        return courseAddService.getAllCourses();
    }

    @GetMapping("/students")
    public Object fetchStudents() {
        return courseAddService.getAllStudents();
    }

    @GetMapping("/registrations")
    public List<Enrollment> fetchEnrollments() {
        return courseAddService.getAllEnrollments();
    }

    @PostMapping("/enroll")
    public String addEnrollment(@RequestBody Enrollment enrollment) {
        return courseAddService.addCourse(enrollment);
    }
}
