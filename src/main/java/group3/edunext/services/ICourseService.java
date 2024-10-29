package group3.edunext.services;

import group3.edunext.models.Course;

import java.util.List;

public interface ICourseService {
    List<Course> getAllCourses();
    Course getCourseById(int courseId);
    List<Course> getMyCourses(Integer studentId, Integer semesterId);
}
