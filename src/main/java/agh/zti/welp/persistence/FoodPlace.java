package agh.zti.welp.persistence;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "foodplaces")
public class FoodPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", columnDefinition = "TEXT", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "foodPlace", cascade = CascadeType.ALL)
    private Set<Rating> ratings;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public FoodPlace() {
    }

    public FoodPlace(String name) {
        this.name = name;
    }

    public FoodPlace(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> rating) {
        this.ratings = rating;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
