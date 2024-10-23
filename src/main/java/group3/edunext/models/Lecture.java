package group3.edunext.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Lecture {
    @Id
    @Column(name = "LectureID", nullable = false)
    private Integer id;

    @Column(name = "LectureName", nullable = false, length = 100)
    private String lectureName;

    @Lob
    @Column(name = "LectureMaterial")
    private String lectureMaterial;

    @Column(name = "TeachingStatus", length = 20)
    private String teachingStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")
    private User userID;

}