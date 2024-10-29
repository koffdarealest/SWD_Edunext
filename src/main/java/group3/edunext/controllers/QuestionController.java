package group3.edunext.controllers;

import group3.edunext.models.Course;
import group3.edunext.models.Question;
import group3.edunext.services.ICourseService;
import group3.edunext.services.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final IQuestionService questionService;
    private final ICourseService courseService;

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
        return "questionDetail";
    }
}
