package group3.edunext.repositories;

import group3.edunext.models.StudentQuestion;
import group3.edunext.models.StudentQuestionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentQuestionRepository extends JpaRepository<StudentQuestion, StudentQuestionId> {
}