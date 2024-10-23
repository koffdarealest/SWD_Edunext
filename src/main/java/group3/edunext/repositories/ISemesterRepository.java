package group3.edunext.repositories;

import group3.edunext.models.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISemesterRepository extends JpaRepository<Semester, Integer> {
}