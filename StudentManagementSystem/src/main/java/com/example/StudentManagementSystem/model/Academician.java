package com.example.StudentManagementSystem.model;

import jakarta.persistence.*;
//import java.time.LocalDate;

@Entity
@Table(name = "Academicians")
public class Academician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long academicAdvisorID;

    @Column(name = "FullName", nullable = false)
    private String fullName;

    @Column(name = "Title")
    private String title;

    @Column(name = "Department")
    private String department;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    public Long getAcademicAdvisorID() {
        return academicAdvisorID;
    }

    public void setAcademicAdvisorID(Long academicAdvisorID) {
        this.academicAdvisorID = academicAdvisorID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}