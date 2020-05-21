package agh.zti.welp.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    ArrayList<Category> findAll();
    void deleteCategoryById(long id);
    Category getCategoryById(long id);

}
