package agh.zti.welp.controllers;

import agh.zti.welp.controllers.presentations.CategoryPresentation;
import agh.zti.welp.logic.CategoryService;
import agh.zti.welp.persistence.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("rest/category")
public class CategoryController {

    private CategoryService categoryService;
    private static Logger LOG = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<CategoryPresentation> getAllCategories(){
        LOG.debug("Executing getAll");
        return categoryService.getAllCategories();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable("id") long id){
        LOG.debug("Executing deleteCategory with id: " + id);
        categoryService.deleteCategoryById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public CategoryPresentation addCategory(@RequestBody String login){
        LOG.debug("Executing createCategory with name: " + login);
        return new CategoryPresentation(categoryService.addCategory(login));
    }

}
