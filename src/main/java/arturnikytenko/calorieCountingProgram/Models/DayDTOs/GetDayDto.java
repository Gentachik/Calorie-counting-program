package arturnikytenko.calorieCountingProgram.Models.DayDTOs;

import arturnikytenko.calorieCountingProgram.Models.DayModel;
import arturnikytenko.calorieCountingProgram.Models.FoodDTOs.GetFoodDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GetDayDto {
    private double neededCalorie;
    private double neededProtein;
    private double neededCarbohydrate;
    private double neededFat;
    private double bmi;
    private String date;
    private List<GetFoodDTO> foods;

    public GetDayDto(DayModel day) {
        date = day.getDate();
        neededCalorie = day.getNeededCalorie();
        neededProtein = day.getNeededProtein();
        neededCarbohydrate = day.getNeededCarbohydrate();
        neededFat = day.getNeededFat();
        bmi = day.getBMI();
    }

}
