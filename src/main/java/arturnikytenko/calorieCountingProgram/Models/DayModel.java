package arturnikytenko.calorieCountingProgram.Models;

import arturnikytenko.calorieCountingProgram.Utilities.GlobalVariables;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@Entity
public class DayModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dayId;
    private double neededCalorie;
    private double neededProtein;
    private double neededCarbohydrate;
    private double neededFat;
    private String date;
    private double BMI;

    @ManyToOne
    @JoinColumn(name = "creator", nullable = false)
    @JsonIgnore
    private UserModel creator;

    @OneToMany(mappedBy = "day", cascade = {CascadeType.PERSIST}, orphanRemoval = true)
    @JsonIgnore
    private Set<FoodDay> foodDays = new HashSet<>();
    public DayModel(UserModel creator) {
        this.creator = creator;
        date = GlobalVariables.SDF.format(new Date());
        neededCalorie = 88.362 + ((GlobalVariables.CALORIE_WEIGHT_MULTIPLIER * creator.getWeight()) +
                (GlobalVariables.CALORIE_HEIGHT_MULTIPLIER * creator.getHeight()) -
                (GlobalVariables.CALORIE_AGE_MULTIPLIER * creator.getAge()));
        neededProtein = creator.getWeight();
        neededCarbohydrate = neededCalorie * GlobalVariables.CARB_PERCENTAGE;
        neededFat = neededCalorie * GlobalVariables.FAT_PERCENTAGE;
        switch (creator.getGoal()) {
            case gainWeight -> this.BMI = neededCalorie * GlobalVariables.BMI_GAIN;
            case loseWeight -> this.BMI = neededCalorie * GlobalVariables.BMI_LOSS;
            default -> this.BMI = neededCalorie;
        }
    }

    public DayModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayModel dayModel = (DayModel) o;
        return Objects.equals(date, dayModel.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public String toString() {
        return "DayModel{" +
                "dayId=" + dayId +
                '}';
    }
}
