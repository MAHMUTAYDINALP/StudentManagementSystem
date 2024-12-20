package com.example.StudentManagementSystem.service;

import com.example.StudentManagementSystem.model.Academician;
//import com.example.StudentManagementSystem.model.User;
import com.example.StudentManagementSystem.repository.AcademicianRepository;
//import com.example.StudentManagementSystem.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicianService {

    private final AcademicianRepository academicianRepository;

    public Academician createAcademician(Academician academician) {
        return academicianRepository.save(academician);
    }

    public AcademicianService(AcademicianRepository academicianRepository) {  
        this.academicianRepository = academicianRepository;
    }

    public List<Academician> getAllAcademicians() {               //bütün akademisyenleri listeleyen fonksiyon
        return academicianRepository.findAll();
    }

    public Academician getAcademicianById(Long id) {              //id ile akadmisyen getiren fonkisyon
        Optional<Academician> academician=academicianRepository.findById(id);
        if(academician.isPresent()){

            return academician.get();
        }
        
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user not found ");
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