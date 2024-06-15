package arturnikytenko.calorieCountingProgram.Models;

import jakarta.persistence.*;

@Entity
public class FoodDay {
    @EmbeddedId
    private FoodDayKey id;
    @ManyToOne
    @MapsId("foodId")
    @JoinColumn(name = "food_id")
    private FoodModel food;

    @ManyToOne
    @MapsId("dayId")
    @JoinColumn(name = "day_id")
    private DayModel day;

    public FoodDay() {
    }

    public FoodDayKey getId() {
        return id;
    }

    public void setId(FoodDayKey id) {
        this.id = id;
    }

    public FoodModel getFood() {
        return food;
    }

    public void setFood(FoodModel food) {
        this.food = food;
    }

    public DayModel getDay() {
        return day;
    }

    public void setDay(DayModel day) {
        this.day = day;
    }
}
