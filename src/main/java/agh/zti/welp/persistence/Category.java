package agh.zti.welp.persistence;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 127, unique = true, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
    private Set<FoodPlace> foodPlaces;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<FoodPlace> getFoodPlaces() {
        return foodPlaces;
    }

    public void setFoodPlaces(Set<FoodPlace> foodPlaces) {
        this.foodPlaces = foodPlaces;
    }

    public Long getId() {
        return id;
    }
}
