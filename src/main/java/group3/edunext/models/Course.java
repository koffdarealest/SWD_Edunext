package group3.edunext.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Course {
    @Id
    @Column(name = "CourseID", nullable = false)
    private Integer id;

    @Column(name = "CourseName", nullable = false, length = 100)
    private String courseName;

    @Lob
    @Column(name = "CourseDescription")
    private String courseDescription;

    @Column(name = "CreditPoints")
    private Integer creditPoints;

    @Column(name = "Create_at")
    private LocalDate createAt;

    @Column(name = "Update_at")
    private LocalDate updateAt;

    @Column(name = "Status", length = 20)
    private String status;


}