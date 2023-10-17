package addict2code.university_v10.dao;

import addict2code.university_v10.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> findAll();

    Category findOne(int category_id);
}
