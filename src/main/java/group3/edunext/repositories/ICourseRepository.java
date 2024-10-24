package group3.edunext.repositories;

import group3.edunext.models.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer> {
    @Query("Select id from Course ")
    List<Course> getAllCourses();
}