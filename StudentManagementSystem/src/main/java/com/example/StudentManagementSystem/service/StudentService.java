package com.example.StudentManagementSystem.service;

import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.repository.StudentRepository;
//import com.example.StudentManagementSystem.repository.UserRepository;

import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // bütün ögrencileir getiren fonksiyon
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // id ile ögrneic getiren fonkisyon
    public Student getStudentById(Long id) {
       Optional<Student> student=studentRepository.findById(id);
       if(student.isPresent()){

        return student.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"student mot found");
    }


    // ögrenci ekleyen fonkisyon
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // ögrenci güncelleyen fonkisyon
    public Student updateStudent(Long id, Student studentDetails) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setFirstName(studentDetails.getFirstName()); // İlk isim güncelleniyor
                    student.setLastName(studentDetails.getLastName());   // Soy isim güncelleniyor
                    student.setEmail(studentDetails.getEmail());
                    student.setDepartment(studentDetails.getDepartment());
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }

    // id ile ögrenci silen fonksiyon
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}