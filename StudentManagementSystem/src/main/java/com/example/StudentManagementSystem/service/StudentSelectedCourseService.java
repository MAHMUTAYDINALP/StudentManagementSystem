// StudentSelectedCourseService.java
package com.example.StudentManagementSystem.service;

import com.example.StudentManagementSystem.model.StudentSelectedCourse;
import com.example.StudentManagementSystem.repository.StudentSelectedCourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Servis katmanını belirten Spring anotasyonu
public class StudentSelectedCourseService {

    private final StudentSelectedCourseRepository studentSelectedCourseRepository;

    // Dependency injection (bağımlılık enjeksiyonu) ile repository sınıfını kullanıyoruz.
    public StudentSelectedCourseService(StudentSelectedCourseRepository studentSelectedCourseRepository) {
        this.studentSelectedCourseRepository = studentSelectedCourseRepository;
    }

    // Tüm  dersleri getiren fonksiyon
    public List<StudentSelectedCourse> getAllStudentSelectedCourses() {
        return studentSelectedCourseRepository.findAll();
    }

    // id ile ders getiren fonksiyon
    public Optional<StudentSelectedCourse> getStudentSelectedCourseById(Long id) {
        return studentSelectedCourseRepository.findById(id);
    }

    // Yeni  ders  ekleyen fonksiyon
    public StudentSelectedCourse addStudentSelectedCourse(StudentSelectedCourse studentSelectedCourse) {
        return studentSelectedCourseRepository.save(studentSelectedCourse);
    }

    // ders bilgileirni güncelleyen fonksiyon
    public StudentSelectedCourse updateStudentSelectedCourse(Long id, StudentSelectedCourse studentSelectedCourseDetails) {
        return studentSelectedCourseRepository.findById(id)
                .map(studentSelectedCourse -> {
                    studentSelectedCourse.setCourse(studentSelectedCourseDetails.getCourse()); // Ders ID güncelleniyor
                    studentSelectedCourse.setStudent(studentSelectedCourseDetails.getStudent()); // Öğrenci ID güncelleniyor
                    studentSelectedCourse.setIsApproved(studentSelectedCourseDetails.getIsApproved()); // Onay durumu güncelleniyor
                    studentSelectedCourse.setSelectionDate(studentSelectedCourseDetails.getSelectionDate()); // Seçim tarihi güncelleniyor
                    return studentSelectedCourseRepository.save(studentSelectedCourse);
                })
                .orElseThrow(() -> new RuntimeException("StudentSelectedCourse not found with id " + id));
    }

    // id ile  ders silen fonksiyon
    public void deleteStudentSelectedCourse(Long id) {
        studentSelectedCourseRepository.deleteById(id);
    }
}
