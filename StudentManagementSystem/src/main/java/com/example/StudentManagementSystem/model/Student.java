  /*   package com.example.StudentManagementSystem.model;

    import jakarta.persistence.*;     //veri tabanı ile nesneleri eşlemeye yarayacak api  
    import lombok.Getter;       //get metotlarını otomatik oluşturabilecek kütüphane.
    import lombok.Setter;       //setter metotlarını otomatik oluşturabilecek kütüphane 

    @Getter         //get metotlarını otomatik yazar her varlık için        
    @Setter         //set metotlarını otomatik yazar her varlık için       
    @Entity     
    @Table(name="Students")  //tabloyu kullanıcılar tablosu ile eşler

        public class Student{

            @Id             //primary key olması için
            @GeneratedValue(strategy=GenerationType.IDENTITY) // otomatik artan primary key için 
            private Long studentID;

            @Column(name="FirstName",nullable=false)  // veri tabanındaki firtsname kolonuna eşitledik nullable de boş olabilmesi için false yaptıl null degeri almasın diye
            private String firstName;

            @Column(name = "LastName", nullable = false)
            private String lastName;

            @Column(name = "Email", nullable = false, unique = true)   //ekstra olarak email aynı olamayacagı için unique benzersiz olma şartı koştuk
            private String email;

            @Column(name = "AcademicAdvisorID")
            private Long academicAdvisorID;

            @Column(name = "Department")
            private String department;

                    

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }
                
                    
        }*/

        package com.example.StudentManagementSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Students") // Öğrenciler tablosuyla eşleşiyor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentID; // Primary Key

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "AcademicAdvisorID")
    private Long academicAdvisorID;

    @Column(name = "Department")
    private String department;

    // Getter ve Setter metotları
    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAcademicAdvisorID() {
        return academicAdvisorID;
    }

    public void setAcademicAdvisorID(Long academicAdvisorID) {
        this.academicAdvisorID = academicAdvisorID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
