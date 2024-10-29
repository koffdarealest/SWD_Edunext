package group3.edunext.services;

import group3.edunext.models.Question;

import java.util.List;

public interface IQuestionService {
    List<Question> getQuestionsByCourseId(int courseId);
    Question getQuestionById(int questionId);
}
