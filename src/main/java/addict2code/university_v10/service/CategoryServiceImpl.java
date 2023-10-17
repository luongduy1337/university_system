package addict2code.university_v10.service;

import addict2code.university_v10.dao.CategoryDAO;
import addict2code.university_v10.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryDAO categoryDAO;

    // initialize constructor
    public CategoryServiceImpl(CategoryDAO theCategoryDAO){
        this.categoryDAO = theCategoryDAO;
    }
    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Category findOne(int category_id) {
        return categoryDAO.findOne(category_id);
    }
}
