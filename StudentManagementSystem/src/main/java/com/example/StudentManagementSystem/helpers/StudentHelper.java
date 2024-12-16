package com.example.StudentManagementSystem.helpers;

public class StudentHelper {
    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }
}
