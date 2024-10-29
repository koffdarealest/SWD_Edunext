package group3.edunext.controllers;

import group3.edunext.models.Course;
import group3.edunext.models.Semester;
import group3.edunext.services.ICourseService;
import group3.edunext.services.ISemesterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService courseService;
    private final ISemesterService semesterService;
    @RequestMapping(value = {"/coursesList"}, method = RequestMethod.GET)
    public String coursesList(Model model) {

         List<Course> courses = courseService.getMyCourses(0, 1);
         List<Semester> semesters = semesterService.getAllSemester();

         model.addAttribute("courses", courses);
         model.addAttribute("semesters", semesters);
        return "courseList";
    }

    @PostMapping(value = {"/coursesList"})
    public String coursesListPost(Model model, @RequestParam Integer semester) {

        List<Course> courses = courseService.getMyCourses(0, semester);
        List<Semester> semesters = semesterService.getAllSemester();

        model.addAttribute("courses", courses);
        model.addAttribute("semesters", semesters);
        return "courseList";
    }

}
