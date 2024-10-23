package group3.edunext.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Semester {
    @Id
    @Column(name = "SemesterID", nullable = false)
    private Integer id;

    @Column(name = "SemesterName", nullable = false, length = 100)
    private String semesterName;

    @Column(name = "\"Year\"", nullable = false)
    private Integer year;

    @Column(name = "Start_date")
    private LocalDate startDate;

    @Column(name = "End_date")
    private LocalDate endDate;

}