package com.example.StudentManagementSystem.helpers;

import com.example.StudentManagementSystem.model.Academician;

public class AcademicianHelper {

    // Akademisyen verisini doğrulayan bir metot.
    public static boolean isValidAcademician(Academician academician) {
        return academician != null &&
               academician.getFullName() != null &&
               !academician.getFullName().isEmpty();
    }

    // Loglama işlemi (sadece örnek amaçlı)
    public static void logAcademicianDetails(Academician academician) {
        System.out.println("Academician Details: " + academician.toString());
    }
}
