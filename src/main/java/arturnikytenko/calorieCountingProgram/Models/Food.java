package arturnikytenko.calorieCountingProgram.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
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
    @JoinColumn(name = "creator", nullable = false)
    @JsonIgnore
    private UserModel creator;

    @OneToMany(mappedBy = "food", cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JsonIgnore
    Set<FoodDay> foodDays = new HashSet<>();

    @ManyToMany(mappedBy = "dislikedFoods", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<UserModel> usersThatDislike = new HashSet<>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return id == food.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
