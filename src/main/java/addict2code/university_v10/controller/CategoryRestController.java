package addict2code.university_v10.controller;

import addict2code.university_v10.entity.Category;
import addict2code.university_v10.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryRestController {
    private CategoryService categoryService;

    public CategoryRestController(CategoryService theCategoryService){
        this.categoryService = theCategoryService;
    }

    @GetMapping("/category")
    List<Category> findAll(){
     return categoryService.findAll();
    }

    @GetMapping("/category/{categoryId}")
    Category findOne(@PathVariable int categoryId){
        return categoryService.findOne(categoryId);
    }

}
