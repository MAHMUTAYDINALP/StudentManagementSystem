   package com.example.StudentManagementSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Students") // Öğrenciler tablosuyla eşleşiyor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentID; // Primary Key

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "AcademicAdvisorID")
    private Long academicAdvisorID;

    @Column(name = "Department")
    private String department;  

    // Getter ve Setter metotları
    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAcademicAdvisorID() {
        return academicAdvisorID;
    }

    public void setAcademicAdvisorID(Long academicAdvisorID) {
        this.academicAdvisorID = academicAdvisorID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
