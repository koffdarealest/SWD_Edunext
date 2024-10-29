package group3.edunext.services.implement;

import group3.edunext.models.Course;
import group3.edunext.repositories.ICourseRepository;
import group3.edunext.services.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService {

    private final ICourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(int courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }

    @Override
    public List<Course> getMyCourses(Integer studentId, Integer semesterId) {
        List<Course> result = courseRepository.getMyCourse1(studentId, semesterId);
        for (Course course : result) {
            if (!course.getStatus().equals(("Active"))) {
                result.remove(course);
            }
        }
        return result;
    }
}
