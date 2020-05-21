package agh.zti.welp.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RatingRepository extends CrudRepository<Rating,Long> {

    ArrayList<Rating> findAll();
    ArrayList<Rating> getRatingsByUser(User user);
    Rating getRatingByFoodPlaceAndUser(FoodPlace foodPlace, User user);

}
