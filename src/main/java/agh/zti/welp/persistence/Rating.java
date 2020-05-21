package agh.zti.welp.persistence;


import javax.persistence.*;

@Entity
@Table(name="ratings", uniqueConstraints =
@UniqueConstraint(columnNames = {"user_id", "food_place_id"}))
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "rating", nullable = false)
    private int rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_place_id", nullable = false)
    private FoodPlace foodPlace;

    public Rating() {
    }

    public Rating(User user, FoodPlace foodPlace) {
        this.user = user;
        this.foodPlace = foodPlace;
    }

    public Long getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FoodPlace getFoodPlace() {
        return foodPlace;
    }

    public void setFoodPlace(FoodPlace foodPlace) {
        this.foodPlace = foodPlace;
    }
}
