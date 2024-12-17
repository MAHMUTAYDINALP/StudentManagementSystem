package com.example.StudentManagementSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;               //aynı gerekli kütphaneleri ekledim 

@Getter
@Setter
@Entity
@Table(name = "Users")              //tablosuyla eşitledim
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;                                        //pk olarak tanımladım
    
    @Column(name = "Username", nullable = false, unique = true)
    private String username;

    @Column(name = "Role", nullable = false)
    private String role;

    @Column(name = "PasswordHash", nullable = false)
    private String passwordHash;

    @Column(name = "ConnectionID")
    private Long connectionID;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

}
    
