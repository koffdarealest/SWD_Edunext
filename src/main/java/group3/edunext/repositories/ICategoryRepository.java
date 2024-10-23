package group3.edunext.repositories;

import group3.edunext.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAll();
    Category findByCategoryName(String categoryName);
}