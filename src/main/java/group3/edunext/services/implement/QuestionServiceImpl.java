package group3.edunext.services.implement;

import group3.edunext.models.Course;
import group3.edunext.models.Question;
import group3.edunext.models.StudentQuestion;
import group3.edunext.repositories.ICourseRepository;
import group3.edunext.repositories.IQuestionRepository;
import group3.edunext.repositories.IStudentQuestionRepository;
import group3.edunext.services.ICourseService;
import group3.edunext.services.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements IQuestionService {

    private final IQuestionRepository questionRepository;
    private final ICourseRepository courseRepository;
    private final IStudentQuestionRepository studentQuestionRepository;

    public List<Question> getQuestionsByCourseId(int courseId) {
        Course course = courseRepository.findById(courseId).orElse(null);
        return questionRepository.findQuestionsByCourseID(course);
    }

    public Question getQuestionById(int questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }

    @Override
    public void InsertAnswer(StudentQuestion item) {
        studentQuestionRepository.save(item);
    }

    @Override
    public List<StudentQuestion> getAnswersByQuestionId(int questionId) {
        return studentQuestionRepository.getStudentQuestionByQuestionID(questionId);
    }


}
