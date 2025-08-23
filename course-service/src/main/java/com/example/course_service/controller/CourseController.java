package com.example.course_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course_service.dao.Course;
import com.example.course_service.service.CourseService;

@RestController
@RequestMapping("api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course createStudent(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/id/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/code/{course_code}")
    public List<Course> getCourseByCourseCode(@PathVariable String course_code) {
        return courseService.getCourseByCourseCode(course_code);
    }

    @PutMapping("/{id}")
    public Course updateCourseById(@PathVariable Long id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }
}
