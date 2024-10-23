package group3.edunext.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Class {
    @Id
    @Column(name = "ClassID", nullable = false)
    private Integer id;

    @Column(name = "ClassName", nullable = false, length = 100)
    private String className;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CourseID")
    private Course courseID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SemesterID")
    private Semester semesterID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LecturerID")
    private Lecture lecturerID;

}