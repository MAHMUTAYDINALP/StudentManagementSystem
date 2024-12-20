package com.example.StudentManagementSystem.controller;

import com.example.StudentManagementSystem.helpers.CourseHelper;
//import com.example.StudentManagementSystem.model.Academician;
import com.example.StudentManagementSystem.model.Course;
import com.example.StudentManagementSystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private final CourseService courseService;

   
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

   /*  @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id)
                                    .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        return ResponseEntity.ok(course);
    }
    */
@GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

  /*  @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody Course course) {
        if (!CourseHelper.isValidCourse(course)) {
            return ResponseEntity.badRequest().body("Geçersiz Ders Bilgisi!");
        }
        return ResponseEntity.ok(courseService.createCourse(course));
    }
*/

@PostMapping("/courses")
public Course createCourse(@RequestBody Course course) {
    return courseService.addCourse(course); // Doğru servis metodu çağrılıyor
}
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        if (!CourseHelper.isValidCourse(course)) {
            return ResponseEntity.badRequest().body("Geçersiz Ders Bilgisi!");
        }
        return ResponseEntity.ok(courseService.updateCourse(id, course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
