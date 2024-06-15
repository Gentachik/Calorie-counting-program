package arturnikytenko.calorieCountingProgram.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Embeddable
public class FoodDayKey implements Serializable {
    @Column(name = "day_id")
    int dayId;

    @Column(name = "food_id")
    int foodId;

    public FoodDayKey() {
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
}
