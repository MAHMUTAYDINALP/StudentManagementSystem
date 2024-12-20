    /*package com.example.StudentManagementSystem.model;

    import java.time.LocalDate;

    import jakarta.persistence.*;
    import lombok.Getter;                   //aynı gerekli kütüphaneleri ekledim
    import lombok.Setter;

    @Getter
    @Setter
    @Entity
    @Table(name = "StudentSelectedCourses")         //tablosuyla eşitledim 
    public class StudentSelectedCourse {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long selectedCourseID;                              //pk degişkenimi tanımladım

        @ManyToOne
        @JoinColumn(name = "LessonID", nullable = false)        // burada ilişki bulunan varlıklar arasındaki ilişki türünüde yazdım 
        private Course course;

        @ManyToOne
        @JoinColumn(name = "StudentID", nullable = false)
        private Student student;

        @Column(name = "IsApproved", nullable = false)
        private Boolean isApproved;

        @Column(name = "SelectionDate", nullable = false)
        private LocalDate selectionDate;

        private Long id;
        private Long dersID;
        private Long ögrenciID;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getDersID() {
            return dersID;
        }

        public void setDersID(Long dersID) {
            this.dersID = dersID;
        }

        public Long getÖgrenciID() {
            return ögrenciID;
        }

        public void setÖgrenciID(Long ögrenciID) {
            this.ögrenciID = ögrenciID;
        }
        

    }*/

    package com.example.StudentManagementSystem.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "StudentSelectedCourses") // Öğrencilerin seçtiği dersler tablosuyla eşleşiyor
public class StudentSelectedCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long selectedCourseID; // Primary Key

    @ManyToOne
    @JoinColumn(name = "LessonID", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "StudentID", nullable = false)
    private Student student;

    @Column(name = "IsApproved", nullable = false)
    private Boolean isApproved;

    @Column(name = "SelectionDate", nullable = false)
    private LocalDate selectionDate;

    // Getter ve Setter metotları
    public Long getSelectedCourseID() {
        return selectedCourseID;
    }

    public void setSelectedCourseID(Long selectedCourseID) {
        this.selectedCourseID = selectedCourseID;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public LocalDate getSelectionDate() {
        return selectionDate;
    }

    public void setSelectionDate(LocalDate selectionDate) {
        this.selectionDate = selectionDate;
    }


    //-----------------

    private Long id;
    private Long dersID;
    private Long ögrenciID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDersID() {
        return dersID;
    }

    public void setDersID(Long dersID) {
        this.dersID = dersID;
    }

    public Long getÖgrenciID() {
        return ögrenciID;
    }

    public void setÖgrenciID(Long ögrenciID) {
        this.ögrenciID = ögrenciID;
    }
    
    
}
