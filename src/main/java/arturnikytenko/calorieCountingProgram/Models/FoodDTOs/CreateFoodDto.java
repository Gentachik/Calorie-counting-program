package arturnikytenko.calorieCountingProgram.Models.FoodDTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateFoodDto {
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

}
