package com.example.StudentManagementSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;                   //aynı şekilde gerekli aynı kütüphaneleri ekledim

@Getter
@Setter
@Entity
@Table(name = "Courses")                //dersler tablosuyla eşitledim
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column (name="LessonID")           // pk olarak tanımladım
    private Long CourseID ;

    @Column(name = "LessonName", nullable = false)                  //null olamaz       
    private String CourseName;

    @Column(name = "LessonCode", nullable = false, unique = true)       //null olamaz , ve beznersiz unıque olmalı ki her ders birbirinden ayıralabilsin
    private String CourseCode;

    @Column(name = "Credits", nullable = false)
    private Integer credits;

    @Column(name = "IsMandatory", nullable = false)
    private Boolean isMandatory;

    @Column(name = "Department")
    private String department;

    @ManyToOne
    @JoinColumn(name = "AcademicianID", nullable = false)
    private Academician academician;

    public boolean isMandatory() {
        return isMandatory;
    }
    
    public void setMandatory(boolean mandatory) {
        isMandatory = mandatory;
    }
    
    
}
