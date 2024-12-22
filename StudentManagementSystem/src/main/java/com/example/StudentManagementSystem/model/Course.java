

package com.example.StudentManagementSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Courses") // Dersler tablosuyla eşleşiyor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LessonID")
    private Long courseID; // Primary Key

    @Column(name = "LessonName", nullable = false)
    private String courseName;

    @Column(name = "LessonCode", nullable = false, unique = true)
    private String courseCode;

    @Column(name = "Credits", nullable = false)
    private Integer credits;

    @Column(name = "IsMandatory", nullable = false)
    private Boolean isMandatory;

    @Column(name = "Department")
    private String department;

    @ManyToOne
    @JoinColumn(name = "AcademicianID", nullable = false)
    private Academician academician;

    // Getter ve Setter metotları
    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Boolean getIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(Boolean isMandatory) {
        this.isMandatory = isMandatory;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Academician getAcademician() {
        return academician;
    }

    public void setAcademician(Academician academician) {
        this.academician = academician;
    }

    public boolean isMandatory() {
        return isMandatory;
    }
    
    public void setMandatory(boolean mandatory) {
        isMandatory = mandatory;
    }
}
