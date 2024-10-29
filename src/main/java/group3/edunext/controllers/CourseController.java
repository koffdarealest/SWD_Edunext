package group3.edunext.controllers;

import group3.edunext.models.Course;
import group3.edunext.services.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService courseService;

    @RequestMapping(value = {"/coursesList"}, method = RequestMethod.GET)
    public String coursesList(Model model) {
         List<Course> courses = courseService.getAllCourses();
         model.addAttribute("courses", courses);

        return "courseList";
    }


}
