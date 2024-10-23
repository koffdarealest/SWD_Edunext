package group3.edunext.repositories;

import group3.edunext.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course, Integer> {
}