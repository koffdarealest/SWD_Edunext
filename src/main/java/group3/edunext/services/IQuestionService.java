package group3.edunext.services;

import group3.edunext.models.Question;
import group3.edunext.models.StudentQuestion;

import java.util.List;

public interface IQuestionService {
    List<Question> getQuestionsByCourseId(int courseId);
    Question getQuestionById(int questionId);
    void InsertAnswer(StudentQuestion item);
    List<StudentQuestion> getAnswersByQuestionId(int questionId);
}
