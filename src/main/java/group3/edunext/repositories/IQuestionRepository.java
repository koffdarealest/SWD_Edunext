package group3.edunext.repositories;

import group3.edunext.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionRepository extends JpaRepository<Question, Integer> {

}