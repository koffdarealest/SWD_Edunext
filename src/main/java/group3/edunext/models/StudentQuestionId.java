package group3.edunext.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class StudentQuestionId implements Serializable {
    private static final long serialVersionUID = -2571056315687110114L;
    @Column(name = "StudentID", nullable = false)
    private Integer studentID;

    @Column(name = "QuestionID", nullable = false)
    private Integer questionID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StudentQuestionId entity = (StudentQuestionId) o;
        return Objects.equals(this.studentID, entity.studentID) &&
                Objects.equals(this.questionID, entity.questionID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, questionID);
    }

}