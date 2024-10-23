package group3.edunext.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @Column(name = "QuestionID", nullable = false)
    private Integer id;

    @Column(name = "QuestionDescription", nullable = false)
    private String questionDescription;

    @Column(name = "QuestionType", nullable = false, length = 25)
    private String questionType;

    @Column(name = "CorrectAnswer", length = 100)
    private String correctAnswer;

    @Column(name = "CreateDate", nullable = false)
    private LocalDate createDate;

    @Column(name = "UpdateDate")
    private LocalDate updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LectureID")
    private Lecture lectureID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CourseID")
    private Course courseID;

}