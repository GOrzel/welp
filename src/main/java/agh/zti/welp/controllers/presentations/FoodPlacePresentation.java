package agh.zti.welp.controllers.presentations;

import agh.zti.welp.persistence.FoodPlace;
import agh.zti.welp.persistence.Rating;

public class FoodPlacePresentation {

    private long id;
    private String name;
    private CategoryPresentation category;
    private double rating;
    private double userRating;

    public FoodPlacePresentation() {

    }

    public FoodPlacePresentation(FoodPlace foodPlace) {
        this.id = foodPlace.getId();
        this.name = foodPlace.getName();
        this.category = new CategoryPresentation(foodPlace.getCategory());
        rating = foodPlace.getRatings().stream().mapToInt(Rating::getRating).average().orElse(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryPresentation getCategory() {
        return category;
    }

    public void setCategory(CategoryPresentation category) {
        this.category = category;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public double getUserRating() {
        return userRating;
    }

    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }
}
