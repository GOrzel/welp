package agh.zti.welp.logic;


import agh.zti.welp.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final FoodPlaceRepository foodPlaceRepository;
    private final UserRepository userRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository,
                         FoodPlaceRepository foodPlaceRepository,
                         UserRepository userRepository){
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.foodPlaceRepository = foodPlaceRepository;
    }

    public void addRating(String login, long foodPlaceId, int userRating){
        FoodPlace foodPlace = foodPlaceRepository.getFoodPlaceById(foodPlaceId);
        User user = userRepository.getUserByLogin(login);
        Rating rating = ratingRepository.getRatingByFoodPlaceAndUser(foodPlace, user);
        if(rating == null){
            rating = new Rating(user, foodPlace);
        }
        rating.setRating(userRating);
        ratingRepository.save(rating);
    }

    public ArrayList<Rating> getRatingsByUser(User user){
        return ratingRepository.getRatingsByUser(user);
    }
}
