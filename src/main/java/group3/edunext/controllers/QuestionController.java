package group3.edunext.controllers;

import group3.edunext.models.Course;
import group3.edunext.models.Question;
import group3.edunext.models.StudentQuestion;
import group3.edunext.models.StudentQuestionId;
import group3.edunext.services.ICourseService;
import group3.edunext.services.IQuestionService;
import group3.edunext.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final IQuestionService questionService;
    private final ICourseService courseService;
    private final IUserService userService;


    @RequestMapping(value = {"/questionList"}, method = RequestMethod.GET)
    public String questionsListById(Model model, @RequestParam int courseId) {
        List<Question> questions = questionService.getQuestionsByCourseId(courseId);
        Course course = courseService.getCourseById(courseId);
        model.addAttribute("questions", questions);
        model.addAttribute("course", course);
        return "questionList";
    }

    @RequestMapping(value = {"/questionDetail"}, method = RequestMethod.GET)
    public String questionDetails(Model model, @RequestParam int questionId) {
        Question question = questionService.getQuestionById(questionId);
        model.addAttribute("question", question);
        List<StudentQuestion> answer = questionService.getAnswersByQuestionId(questionId);
        if (answer == null){
            answer = new ArrayList<>();
        }
        model.addAttribute("answer", answer);
        return "questionDetail";
    }

    @PostMapping(value = {"/questionDetail"})
    public String questionDetailsPost(Model model, @RequestParam String content, @RequestParam int questionId) {
        Question question = questionService.getQuestionById(questionId);

        StudentQuestion answer = new StudentQuestion();
        StudentQuestionId id = new StudentQuestionId();
        id.setQuestionID(questionId);
        id.setStudentID(userService.getStudent(1).getId());
        answer.setDate(LocalDate.now());
        answer.setQuestionID(question);
        answer.setStudentID(userService.getStudent(1));
        answer.setAnswer(content);
        answer.setId(id);

        questionService.InsertAnswer(answer);

        List<StudentQuestion> answers = questionService.getAnswersByQuestionId(questionId);
        if (answers == null){
            answers = new ArrayList<>();
        }
        model.addAttribute("answer", answers);
        model.addAttribute("question", question);
        return "questionDetail";
    }
}
