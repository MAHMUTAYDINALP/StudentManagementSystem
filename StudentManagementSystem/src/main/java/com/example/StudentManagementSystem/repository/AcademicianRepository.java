package com.example.StudentManagementSystem.repository;

import com.example.StudentManagementSystem.model.Academician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicianRepository extends JpaRepository<Academician, Long> {
    
}
