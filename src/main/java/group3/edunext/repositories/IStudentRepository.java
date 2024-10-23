package group3.edunext.repositories;

import group3.edunext.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    
}