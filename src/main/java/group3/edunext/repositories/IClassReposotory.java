package group3.edunext.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClassReposotory  extends JpaRepository<group3.edunext.models.Class,Integer> {
    Optional<group3.edunext.models.Class> findById(int id);
}
