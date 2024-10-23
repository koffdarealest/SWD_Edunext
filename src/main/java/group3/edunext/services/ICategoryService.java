package group3.edunext.services;

import group3.edunext.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategories();
}
