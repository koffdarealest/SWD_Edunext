package group3.edunext.repositories;

import group3.edunext.models.Course;
import group3.edunext.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IQuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findQuestionsByCourseID(Course courseID);
}