package com.example.StudentManagementSystem.repository;

import com.example.StudentManagementSystem.model.StudentSelectedCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSelectedCourseRepository extends JpaRepository<StudentSelectedCourse, Long> {
    
}
