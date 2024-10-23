package group3.edunext.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Student {
    @Id
    @Column(name = "StudentID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")
    private User userID;

    @Column(name = "EnrollmentDate")
    private LocalDate enrollmentDate;

    @Column(name = "LearningStatus", length = 20)
    private String learningStatus;

}