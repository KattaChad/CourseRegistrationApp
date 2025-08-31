package com.example.enrollment_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.enrollment_service.dao.Enrollment;
import com.example.enrollment_service.repository.EnrollmentRepository;

import jakarta.transaction.Transactional;

@Service
public class CourseDropService {
    private final RestTemplate restTemplate;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Value("${students.service.url}")
    private String studentUrl;

    @Value("${courses.service.url}")
    private String courseUrl;

    public CourseDropService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Transactional
    public String dropCourse(Enrollment enrollment) {
        Boolean studentExists = restTemplate.getForObject(
                studentUrl + "/api/students/exists/" + enrollment.getStudentId(),
                Boolean.class);
        Boolean courseExists = restTemplate.getForObject(
                courseUrl + "/api/courses/exists/" + enrollment.getCourseCode(),
                Boolean.class);

        if (Boolean.FALSE.equals(studentExists)) {
            return "Student does not exist";
        }

        if (Boolean.FALSE.equals(courseExists)) {
            return "Course does not exist";
        }

        if (!enrollmentRepository.existsByStudentIdAndCourseCode(enrollment.getStudentId(),
                enrollment.getCourseCode())) {
            return "Enrollment does not exist";
        }

        enrollmentRepository.deleteByStudentIdAndCourseCode(enrollment.getStudentId(), enrollment.getCourseCode());
        return "Course " + enrollment.getCourseCode() + " dropped for student " + enrollment.getStudentId();
    }

}
