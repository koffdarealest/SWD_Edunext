package group3.edunext.controllers;

import group3.edunext.forms.CategoryForm;
import group3.edunext.models.Category;
import group3.edunext.services.implement.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final CategoryServiceImpl categoryService;


    // Dữ liệu lấy ra từ application.properties.
    @Value("${welcome.message}")
    private String message;
    @Value("${error.message}")
    private String errorMessage;



    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        Category c = categoryService.findByCategoryName("PC");
        model.addAttribute("message", message);
        System.out.println(c);
        return "index";
    }


    @RequestMapping(value = {"/categoriesList"}, method = RequestMethod.GET)
    public String categoriesList(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categoriesList";
    }


    @RequestMapping(value = {"/addCategories"}, method = RequestMethod.GET)
    public String showAddCategoriesPage(Model model) {
        CategoryForm categoriesForm = new CategoryForm();
        model.addAttribute("categoriesForm", categoriesForm);
        return "addCategories";
    }


    @RequestMapping(value = {"/addCategories"}, method = RequestMethod.POST)
    public String saveCategories(Model model, @ModelAttribute("categoriesForm") CategoryForm categoriesForm) {
        String firstName = categoriesForm.getName();
        String lastName = categoriesForm.getSlug();
        if (firstName != null && !firstName.isEmpty() //
                && lastName != null && !lastName.isEmpty()) {
            return "redirect:/categoriesList";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "addCategories";
    }
}
