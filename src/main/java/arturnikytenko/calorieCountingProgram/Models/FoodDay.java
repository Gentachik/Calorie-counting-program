package arturnikytenko.calorieCountingProgram.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class FoodDay {
    @EmbeddedId
    private FoodDayKey id;

    @ManyToOne
    @MapsId("foodId")
    @JoinColumn(name = "food_id")
    @JsonIgnore
    private Food food;

    @ManyToOne
    @MapsId("dayId")
    @JoinColumn(name = "day_id")
    @JsonIgnore
    private DayModel day;

    public FoodDay() {
    }

    public FoodDayKey getId() {
        return id;
    }

    public void setId(FoodDayKey id) {
        this.id = id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public DayModel getDay() {
        return day;
    }

    public void setDay(DayModel day) {
        this.day = day;
    }
}
