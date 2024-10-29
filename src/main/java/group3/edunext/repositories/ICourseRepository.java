package group3.edunext.repositories;

import group3.edunext.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICourseRepository extends JpaRepository<Course, Integer> {

@Query("select c from Course c join Class s on c.id = s.courseID.id where :studentId != 100 and s.semesterID.id = :semesterId")
    List<Course> getMyCourse1(@Param("studentId") Integer studentId, @Param("semesterId") Integer semesterId);
}