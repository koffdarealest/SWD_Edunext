package group3.edunext.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Assignment {
    @Id
    @Column(name = "AssignmentID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CourseID")
    private Course courseID;

    @Lob
    @Column(name = "AssignmentDescription")
    private String assignmentDescription;

    @Column(name = "Deadline")
    private LocalDate deadline;

}