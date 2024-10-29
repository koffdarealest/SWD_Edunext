package group3.edunext.repositories;

import group3.edunext.models.StudentQuestion;
import group3.edunext.models.StudentQuestionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentQuestionRepository extends JpaRepository<StudentQuestion, StudentQuestionId> {
    @Query("select s from StudentQuestion s where s.questionID.id = :questionId")
    List<StudentQuestion> getStudentQuestionByQuestionID(@Param("questionId") int questionId);
}