package com.example.StudentManagementSystem.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;                   //aynı gerekli kütüphaneleri ekledim
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "StudentSelectedCourses")         //tablosuyla eşitledim 
public class StudentSelectedCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long selectedCourseID;                              //pk degişkenimi tanımladım

    @ManyToOne
    @JoinColumn(name = "LessonID", nullable = false)        // burada ilişki bulunan varlıklar arasındaki ilişki türünüde yazdım 
    private Course course;

    @ManyToOne
    @JoinColumn(name = "StudentID", nullable = false)
    private Student student;

    @Column(name = "IsApproved", nullable = false)
    private Boolean isApproved;

    @Column(name = "SelectionDate", nullable = false)
    private LocalDate selectionDate;
}