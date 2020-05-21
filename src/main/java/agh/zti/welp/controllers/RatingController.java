package agh.zti.welp.controllers;

import agh.zti.welp.logic.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("rest/rating")
public class RatingController {

    private static Logger LOG = LoggerFactory.getLogger(UserController.class);
    private RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @RequestMapping(value = "/{foodPlaceId}", method = RequestMethod.PUT)
    public void addUpdateRating(@PathVariable("foodPlaceId") long foodPlaceId, @RequestBody String login, @RequestParam int rating) {
        LOG.debug("Executing addUpdateRating with foodPlaceId: " + foodPlaceId + " and login: " + login);
        ratingService.addRating(login, foodPlaceId, rating);
    }

}
