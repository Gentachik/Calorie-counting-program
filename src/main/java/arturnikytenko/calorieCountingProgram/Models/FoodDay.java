package arturnikytenko.calorieCountingProgram.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Setter
@Getter
@Entity
public class FoodDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "food_id")
    @JsonIgnore
    private Food food;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "day_id")
    @JsonIgnore
    private DayModel day;

    private double amount;
    private Date addedAt;

    public FoodDay() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodDay foodDay = (FoodDay) o;
        return id == foodDay.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "FoodDay{" +
                "id=" + id +
                ", amount=" + amount +
                ", addedAt=" + addedAt +
                '}';
    }
}