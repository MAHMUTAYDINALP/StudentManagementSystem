package com.example.StudentManagementSystem.controller;

import com.example.StudentManagementSystem.helpers.AcademicianHelper;
import com.example.StudentManagementSystem.model.Academician;
//import com.example.StudentManagementSystem.model.User;
import com.example.StudentManagementSystem.service.AcademicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/academicians")
public class AcademicianController {

    @Autowired
    private final AcademicianService academicianService;

   
    public AcademicianController(AcademicianService academicianService) {
        this.academicianService = academicianService;
    }

    @GetMapping
    public ResponseEntity<List<Academician>> getAllAcademicians() {
        return ResponseEntity.ok(academicianService.getAllAcademicians());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Academician> getAcademicianById(@PathVariable Long id) {
        return ResponseEntity.ok(academicianService.getAcademicianById(id));
    }

       /*eski  @GetMapping("/{id}")
        public ResponseEntity<Academician> getAcademicianById(@PathVariable Long id) {
            Academician academician = academicianService.getAcademicianById(id)
                                            .orElseThrow(() -> new RuntimeException("Academician not found with id: " + id));
            return ResponseEntity.ok(academician);
        }
*/
 /*    @PostMapping
    public ResponseEntity<?> createAcademician(@RequestBody Academician academician) {
        if (!AcademicianHelper.isValidAcademician(academician)) {
            return ResponseEntity.badRequest().body("Geçersiz Akademisyen Bilgisi!");
        }
        AcademicianHelper.logAcademicianDetails(academician);
        return ResponseEntity.ok(academicianService.createAcademician(academician));
    }*/
       @PostMapping("/academician")
            public Academician createAcademician(@RequestBody Academician academician) {
                return academicianService.addAcademician(academician); // Doğru servis metodu çağrılıyor
        }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAcademician(@PathVariable Long id, @RequestBody Academician academician) {
        if (!AcademicianHelper.isValidAcademician(academician)) {
            return ResponseEntity.badRequest().body("Geçersiz Akademisyen Bilgisi!");
        }
        return ResponseEntity.ok(academicianService.updateAcademician(id, academician));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcademician(@PathVariable Long id) {
        academicianService.deleteAcademician(id);
        return ResponseEntity.noContent().build();
    }
}
