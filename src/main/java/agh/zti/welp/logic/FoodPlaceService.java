package agh.zti.welp.logic;

import agh.zti.welp.controllers.presentations.CategoryPresentation;
import agh.zti.welp.controllers.presentations.FoodPlacePresentation;
import agh.zti.welp.persistence.Category;
import agh.zti.welp.persistence.FoodPlace;
import agh.zti.welp.persistence.FoodPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class FoodPlaceService {

    private final FoodPlaceRepository foodPlaceRepository;
    private final CategoryService categoryService;

    @Autowired
    FoodPlaceService(FoodPlaceRepository foodPlaceRepository, CategoryService categoryService) {
        this.foodPlaceRepository = foodPlaceRepository;
        this.categoryService = categoryService;
    }

    public FoodPlace getFoodPlaceById(Long id) {
        return foodPlaceRepository.getFoodPlaceById(id);
    }

    public ArrayList<FoodPlacePresentation> getAllFoodPlaces() {
        ArrayList<FoodPlacePresentation> result = new ArrayList<>();

        foodPlaceRepository.findAll().forEach(a -> {
            result.add(new FoodPlacePresentation(a));
        });
        return result;
    }

    @Transactional
    public void deleteFoodPlaceById(Long id) {
        foodPlaceRepository.deleteFoodPlaceById(id);
    }

    public FoodPlacePresentation addFoodPlace(FoodPlacePresentation foodPlace) {
        Category category = categoryService.getCategoryById(foodPlace.getCategory().getId());
        return new FoodPlacePresentation(foodPlaceRepository.save(new FoodPlace(foodPlace.getName(), category)));
    }

}
