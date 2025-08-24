package com.example.student_service.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "roll_number")
    private String rollNumber;

    @Column(name = "name")
    private String name;

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return studentId;
    }

    public void setId(Long studentId) {
        this.studentId = studentId;
    }

    public String getRoll_number() {
        return rollNumber;
    }

    public void setRoll_number(String roll_number) {
        this.rollNumber = roll_number;
    }
}
