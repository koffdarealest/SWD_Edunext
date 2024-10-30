package group3.edunext.repositories;

import group3.edunext.models.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IMaterialRepository extends JpaRepository<Material, Integer> {
    @Query("select m from Material m where m.uploadedBy.id = :userId")
    List<Material> getMaterialsByUserId(@Param("userId") int userId);
    Optional<Material> getMaterialById(int id);
}
