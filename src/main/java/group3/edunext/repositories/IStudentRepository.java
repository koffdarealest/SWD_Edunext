package group3.edunext.repositories;

import group3.edunext.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student s WHERE s.userID.id = :userID")
    Student findStudentByUserID(@Param("userID") int userID);
}