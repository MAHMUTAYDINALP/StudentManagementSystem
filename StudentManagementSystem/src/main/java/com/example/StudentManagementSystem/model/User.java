/*package com.example.StudentManagementSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;  // Primary Key

    @Column(name = "Username", nullable = false, unique = true)
    private String username;

    @Column(name = "Role", nullable = false)
    private String role;

    @Column(name = "PasswordHash", nullable = false)
    private String passwordHash;

    @Column(name = "ConnectionID")
    private Long connectionID;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;  // Email tanımı

}
*/



//------------------------------------------------------


package com.example.StudentManagementSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Users") // Kullanıcılar tablosuyla eşleşiyor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID; // Primary Key

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

    // Getter ve Setter metotları
    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Long getConnectionID() {
        return connectionID;
    }

    public void setConnectionID(Long connectionID) {
        this.connectionID = connectionID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}