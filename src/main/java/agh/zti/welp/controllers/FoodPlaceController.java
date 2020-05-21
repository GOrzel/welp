package agh.zti.welp.controllers;

import agh.zti.welp.controllers.presentations.FoodPlacePresentation;
import agh.zti.welp.logic.FoodPlaceService;
import agh.zti.welp.logic.RatingService;
import agh.zti.welp.logic.UserService;
import agh.zti.welp.persistence.FoodPlace;
import agh.zti.welp.persistence.Rating;
import agh.zti.welp.persistence.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@CrossOrigin
@RestController
@RequestMapping("rest/foodplace")
public class FoodPlaceController {

    private FoodPlaceService foodPlaceService;
    private UserService userService;
    private RatingService ratingService;
    private static Logger LOG = LoggerFactory.getLogger(FoodPlaceController.class);

    @Autowired
    public FoodPlaceController(FoodPlaceService foodPlaceService,
                               UserService userService,
                               RatingService ratingService) {
        this.foodPlaceService = foodPlaceService;
        this.userService = userService;
        this.ratingService = ratingService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public FoodPlace getFoodPlace(@PathVariable("id") long id) {
        LOG.debug("Executing getFoodPlace with id: " + id);
        return foodPlaceService.getFoodPlaceById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<FoodPlacePresentation> fetchAllFoodPlaces(@RequestParam String login) {
        LOG.debug("Executing getAll");
        return getAllFoodPlaces(login);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteFoodPlace(@PathVariable("id") long id) {
        LOG.debug("Executing deleteFoodPlace with id: " + id);
        foodPlaceService.deleteFoodPlaceById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public FoodPlacePresentation addFoodPlace(@RequestBody FoodPlacePresentation foodPlace) {
        LOG.debug("Executing createFoodPlace with name: " + foodPlace.getName());
        return foodPlaceService.addFoodPlace(foodPlace);
    }

    private ArrayList<FoodPlacePresentation> getAllFoodPlaces(String login) {
        ArrayList<FoodPlacePresentation> result;
        result = foodPlaceService.getAllFoodPlaces();
        if (login != null) {
            User user = userService.getUserByLogin(login);
            HashMap<Long, Integer> ratings = new HashMap<>();
            ratingService.getRatingsByUser(user).forEach(a -> {
                ratings.put(a.getFoodPlace().getId(), a.getRating());
            });
            result.forEach(a -> {
                if(ratings.containsKey(a.getId())){
                    a.setUserRating(ratings.get(a.getId()));
                }
            });
        }
        return result;
    }

}
