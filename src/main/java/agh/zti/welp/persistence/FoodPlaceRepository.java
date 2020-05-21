package agh.zti.welp.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FoodPlaceRepository extends CrudRepository<FoodPlace, Long> {

    FoodPlace getFoodPlaceById(long id);
    ArrayList<FoodPlace> findAll();
    void deleteFoodPlaceById(long id);

}
