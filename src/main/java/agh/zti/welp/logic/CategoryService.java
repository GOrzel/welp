package agh.zti.welp.logic;


import agh.zti.welp.controllers.presentations.CategoryPresentation;
import agh.zti.welp.persistence.Category;
import agh.zti.welp.persistence.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ArrayList<CategoryPresentation> getAllCategories() {
        ArrayList<CategoryPresentation> result = new ArrayList<>();

        categoryRepository.findAll().forEach(a -> {
            result.add(new CategoryPresentation(a));
        });

        return result;
    }

    @Transactional
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteCategoryById(id);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.getCategoryById(id);
    }

    public Category addCategory(String name) {
        return categoryRepository.save(new Category(name));
    }

}
