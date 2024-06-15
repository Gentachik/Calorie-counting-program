package arturnikytenko.calorieCountingProgram.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;
import java.util.Set;

@Entity
public class FoodModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodId;

    @NotBlank
    private String name;
    @Min(0)
    private double calorie;
    @Min(0)
    private double protein;
    @Min(0)
    private double fat;
    @Min(0)
    private double carbohydrate;

    @ManyToOne
    @JoinColumn(name = "creator", nullable = false)
    @JsonIgnore
    private UserModel creator;

    @OneToMany(mappedBy = "food")
    Set<FoodDay> foodDays;

    @ManyToMany(mappedBy = "dislikedFoods", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<UserModel> usersThatDislike;

    public FoodModel(UserModel creator, double carbohydrate, double fat, double protein, double calorie, String name) {
        this.creator = creator;
        this.carbohydrate = carbohydrate;
        this.fat = fat;
        this.protein = protein;
        this.calorie = calorie;
        this.name = name;
    }

    public FoodModel() {

    }

    public void addDislikedBy(UserModel user) {
        usersThatDislike.add(user);
        user.getDislikedFoods().add(this);
    }

    public void removeDislikedBy(UserModel user) {
        usersThatDislike.remove(user);
        user.getDislikedFoods().remove(this);
    }

    public int getId() {
        return foodId;
    }

    public void setId(int id) {
        this.foodId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public Set<UserModel> getUsersThatDislike() {
        return usersThatDislike;
    }

    public void setUsersThatDislike(Set<UserModel> usersThatDislike) {
        this.usersThatDislike = usersThatDislike;
    }

    public UserModel getCreator() {
        return creator;
    }

    public void setCreator(UserModel creator) {
        this.creator = creator;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public Set<FoodDay> getFoodDays() {
        return foodDays;
    }

    public void setFoodDays(Set<FoodDay> foodDays) {
        this.foodDays = foodDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodModel foodModel = (FoodModel) o;
        return foodId == foodModel.foodId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodId);
    }
}
