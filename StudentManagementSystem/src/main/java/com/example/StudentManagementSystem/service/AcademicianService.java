package com.example.StudentManagementSystem.service;

import com.example.StudentManagementSystem.model.Academician;
import com.example.StudentManagementSystem.repository.AcademicianRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicianService {

    private final AcademicianRepository academicianRepository;

    public AcademicianService(AcademicianRepository academicianRepository) {  
        this.academicianRepository = academicianRepository;
    }

    public List<Academician> getAllAcademicians() {               //bütün akademisyenleri listeleyen fonksiyon
        return academicianRepository.findAll();
    }

    public Optional<Academician> getAcademicianById(Long id) {              //id ile akadmisyen getiren fonkisyon
        return academicianRepository.findById(id);
    }

    public Academician addAcademician(Academician academician) {        // akademisyen ekleyen fonksiyon
        return academicianRepository.save(academician);
    }

    public Academician updateAcademician(Long id, Academician academicianDetails) {             //akademisyen bilgilerini güüncelleyen  fonksiyon
        return academicianRepository.findById(id)
                .map(academician -> {
                    academician.setFullName(academicianDetails.getFullName());
                    academician.setTitle(academicianDetails.getTitle());
                    academician.setDepartment(academicianDetails.getDepartment());
                    return academicianRepository.save(academician);
                })
                .orElseThrow(() -> new RuntimeException("Academician not found with id " + id));
    }

    public void deleteAcademician(Long id) {            //id ile akademisyen silen fonksiyon
        academicianRepository.deleteById(id);
    }
}