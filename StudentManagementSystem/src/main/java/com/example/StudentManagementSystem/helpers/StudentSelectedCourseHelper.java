package com.example.StudentManagementSystem.helpers;

import com.example.StudentManagementSystem.model.StudentSelectedCourse;

public class StudentSelectedCourseHelper {

    public static boolean isValidSelectedCourse(StudentSelectedCourse selectedCourse) {
        return selectedCourse.getDersID() != null && selectedCourse.getÖgrenciID() != null;
    }
}
