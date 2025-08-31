package com.example.enrollment_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.enrollment_service.dao.Enrollment;
import com.example.enrollment_service.service.CourseAddService;
import com.example.enrollment_service.service.CourseDropService;

@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentController {
    private final CourseAddService courseAddService;
    private final CourseDropService courseDropService;

    public EnrollmentController(CourseAddService courseAddService, CourseDropService courseDropService) {
        this.courseAddService = courseAddService;
        this.courseDropService = courseDropService;
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

    @GetMapping("/registrations/{student_id}")
    public List<Enrollment> fetchStudentEnrollments(@PathVariable String student_id) {
        return courseAddService.getCoursesForStudent(student_id);
    }

    @DeleteMapping("/disenroll/{studentId}/{courseCode}")
    public String deleteEnrollment(@PathVariable String studentId, @PathVariable String courseCode) {
        Enrollment enrollment = new Enrollment();
        enrollment.setStudentId(studentId);
        enrollment.setCourseCode(courseCode);
        return courseDropService.dropCourse(enrollment);
    }

}
