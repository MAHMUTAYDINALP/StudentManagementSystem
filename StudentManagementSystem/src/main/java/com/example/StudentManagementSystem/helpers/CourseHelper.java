package com.example.StudentManagementSystem.helpers;

import com.example.StudentManagementSystem.model.Course;

public class CourseHelper {

    public static boolean isValidCourse(Course course) {
        return course != null && course.getCourseName() != null && !course.getCourseName().isEmpty();
    }
}
