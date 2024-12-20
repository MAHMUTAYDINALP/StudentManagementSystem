package com.example.StudentManagementSystem.service;

//import com.example.StudentManagementSystem.model.Academician;
import com.example.StudentManagementSystem.model.Course;
import com.example.StudentManagementSystem.repository.CourseRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service // Servis katmanını oldugunu belirttim 
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }
    
    // Tüm dersleri lisyetleyen fonksiyon
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // ıd ile ders listeleyyen fonksiyon
   /*  public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }*/
    public Course getCourseById(Long id) {              //id ile akadmisyen getiren fonkisyon
        Optional<Course> course=courseRepository.findById(id);
        if(course.isPresent()){

            return course.get();
        }
        
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user not found ");
    }

    // ders ekleyen fonksiyon 
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    //  bir dersi güncelleyen fonksiyon
    public Course updateCourse(Long id, Course courseDetails) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setCourseName(courseDetails.getCourseName()); // Ders adı güncelleniyor
                    course.setCourseCode(courseDetails.getCourseCode()); // Ders kodu güncelleniyor
                    course.setCredits(courseDetails.getCredits()); // Kredi bilgisi güncelleniyor
                    course.setMandatory(courseDetails.isMandatory()); // Zorunlu olup olmadığı bilgisi güncelleniyor
                    return courseRepository.save(course);
                })
                .orElseThrow(() -> new RuntimeException("Course not found with id " + id));
    }

    // id ile bir dersi silen fonksiyon
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}