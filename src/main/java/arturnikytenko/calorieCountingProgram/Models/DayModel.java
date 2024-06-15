package arturnikytenko.calorieCountingProgram.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class DayModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dayId;
    private double neededCalorie;
    private double neededProtein;
    private double neededCarbohydrate;
    private double neededFat;

    @ManyToOne
    @JoinColumn(name = "creator", nullable = false)
    @JsonIgnore
    private UserModel creator;

    @OneToMany(mappedBy = "day")
    Set<FoodDay> foodDays;

    public DayModel() {
    }

    public Set<FoodDay> getFoodDays() {
        return foodDays;
    }

    public void setFoodDays(Set<FoodDay> foodDays) {
        this.foodDays = foodDays;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public double getNeededCalorie() {
        return neededCalorie;
    }

    public void setNeededCalorie(double neededCalorie) {
        this.neededCalorie = neededCalorie;
    }

    public double getNeededProtein() {
        return neededProtein;
    }

    public void setNeededProtein(double neededProtein) {
        this.neededProtein = neededProtein;
    }

    public double getNeededCarbohydrate() {
        return neededCarbohydrate;
    }

    public void setNeededCarbohydrate(double neededCarbohydrate) {
        this.neededCarbohydrate = neededCarbohydrate;
    }

    public double getNeededFat() {
        return neededFat;
    }

    public void setNeededFat(double neededFat) {
        this.neededFat = neededFat;
    }

    public UserModel getCreator() {
        return creator;
    }

    public void setCreator(UserModel creator) {
        this.creator = creator;
    }
}
