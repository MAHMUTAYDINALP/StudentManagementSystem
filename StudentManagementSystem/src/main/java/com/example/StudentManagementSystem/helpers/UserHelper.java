package com.example.StudentManagementSystem.helpers;

import com.example.StudentManagementSystem.model.User;

public class UserHelper {

    public static boolean isValidUser(User user) {
        return user.getUsername() != null && !user.getUsername().isEmpty()
                && user.getEmail() != null && !user.getEmail().isEmpty();
    }
}
