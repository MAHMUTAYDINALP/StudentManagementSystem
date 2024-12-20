package com.example.StudentManagementSystem.controller;

//import com.example.StudentManagementSystem.model.Academician;
//import com.example.StudentManagementSystem.helpers.StudentSelectedCourseHelper;
import com.example.StudentManagementSystem.model.StudentSelectedCourse;
import com.example.StudentManagementSystem.service.StudentSelectedCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student-selected-courses")
public class StudentSelectedCourseController {

    @Autowired
    private final StudentSelectedCourseService studentSelectedCourseService;

    
    public StudentSelectedCourseController(StudentSelectedCourseService studentSelectedCourseService) {
        this.studentSelectedCourseService = studentSelectedCourseService;
    }

    @GetMapping
    public List<StudentSelectedCourse> getAllStudentSelectedCourses() {
        return studentSelectedCourseService.getAllStudentSelectedCourses(); // Düzeltilmiş metod
    }
    
      @GetMapping("/selected-courses")
    public ResponseEntity<StudentSelectedCourse> getStudentSelectedCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(studentSelectedCourseService.getStudentSelectedCourseById(id));
    }

  /*   @GetMapping("/selected-courses/{id}")
    public ResponseEntity<StudentSelectedCourse> getStudentSelectedCourseById(@PathVariable Long id) {
        return studentSelectedCourseService.getStudentSelectedCourseById(id)
                .map(course -> ResponseEntity.ok(course))
                .orElse(ResponseEntity.notFound().build());
    }
    */
    @PostMapping("/selected-courses")
    public StudentSelectedCourse addStudentSelectedCourse(@RequestBody StudentSelectedCourse studentSelectedCourse) {
        return studentSelectedCourseService.addStudentSelectedCourse(studentSelectedCourse);
    }
    
    @PutMapping("/selected-courses/{id}")
    public ResponseEntity<StudentSelectedCourse> updateStudentSelectedCourse(@PathVariable Long id, @RequestBody StudentSelectedCourse studentSelectedCourseDetails) {
        return ResponseEntity.ok(studentSelectedCourseService.updateStudentSelectedCourse(id, studentSelectedCourseDetails));
    }
    
    @DeleteMapping("/selected-courses/{id}")
    public ResponseEntity<?> deleteStudentSelectedCourse(@PathVariable Long id) {
        studentSelectedCourseService.deleteStudentSelectedCourse(id);
        return ResponseEntity.ok().build();
    }
    
}
