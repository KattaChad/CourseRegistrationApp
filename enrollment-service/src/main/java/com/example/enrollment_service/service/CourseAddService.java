package com.example.enrollment_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.enrollment_service.dao.Enrollment;
import com.example.enrollment_service.repository.EnrollmentRepository;

@Service
public class CourseAddService {
    private final RestTemplate restTemplate;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Value("${students.service.url}")
    private String studentUrl;

    @Value("${courses.service.url}")
    private String courseUrl;

    public CourseAddService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String addCourse(Enrollment enrollment) {
        Boolean studentExists = restTemplate.getForObject(studentUrl + "/api/students/exists" + enrollment.getStudentId(), Boolean.class);
        Boolean courseExists = restTemplate.getForObject(courseUrl + "api/courses/exists" + enrollment.getCourseCode(), Boolean.class);

        if(Boolean.FALSE.equals(studentExists)) {
            return "Student does not exist";
        }

        if(Boolean.FALSE.equals(courseExists)) {
            return "Course does not exist";
        }

        enrollmentRepository.save(enrollment);

        return "Enrollment succesful for " + enrollment.getStudentId() + " in course " + enrollment.getCourseCode();
    }

    public Object getAllCourses() {
        String url = courseUrl + "/api/courses";
        return restTemplate.getForObject(url, Object.class);
    }

    public Object getAllStudents() {
        String url = studentUrl + "/api/students";
        return restTemplate.getForObject(url, Object.class);
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
}
