package com.example.StudentManagementSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;   //gerekli aynı kütüphaneleri ekledim

@Getter
@Setter
@Entity
@Table(name = "Academicians")               //tablosuyla eşledim
public class Academician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long academicAdvisorID;                             // pk olarak tanımladım

    @Column(name = "FullName", nullable = false)    
    private String fullName;

    @Column(name = "Title")
    private String title;

    @Column(name = "Department")
    private String department;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

}