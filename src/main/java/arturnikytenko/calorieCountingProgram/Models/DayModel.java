package arturnikytenko.calorieCountingProgram.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
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
    private Date date;
    private double BMR;
    private double TDEE;

    @ManyToOne
    @JoinColumn(name = "creator", nullable = false)
    @JsonIgnore
    private UserModel creator;

    @OneToMany(mappedBy = "day")
    @JsonIgnore
    private Set<FoodDay> foodDays;

    public DayModel(UserModel creator) {
        this.creator = creator;
        date = new Date();
        neededCalorie = 88.362 + ((13.397 * creator.getWeight()) + (4.799 * creator.getHeight()) - (5.677 * creator.getAge()));
        neededProtein = 56;
        neededCarbohydrate = neededCalorie * 0.4;
        neededFat = neededCalorie * 0.3;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getBMR() {
        return BMR;
    }

    public void setBMR(double BMR) {
        this.BMR = BMR;
    }

    public double getTDEE() {
        return TDEE;
    }

    public void setTDEE(double TDEE) {
        this.TDEE = TDEE;
    }
}
