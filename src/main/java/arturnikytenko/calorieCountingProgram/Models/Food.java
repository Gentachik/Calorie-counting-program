package arturnikytenko.calorieCountingProgram.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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
    @JoinColumn(name="creator", nullable=false)
    @JsonIgnore
    private UserModel creator;

    @ManyToMany(mappedBy = "dislikedFoods")
    @JsonIgnore
    private Set<UserModel> usersThatDislike;

    public Food(UserModel creator, double carbohydrate, double fat, double protein, double calorie, String name) {
        this.creator = creator;
        this.carbohydrate = carbohydrate;
        this.fat = fat;
        this.protein = protein;
        this.calorie = calorie;
        this.name = name;
    }

    public Food() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
