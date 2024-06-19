package arturnikytenko.calorieCountingProgram.Models.FoodDTOs;

import arturnikytenko.calorieCountingProgram.Models.Food;
import arturnikytenko.calorieCountingProgram.Models.FoodDay;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class GetFoodDTO {
    private int id;
    private String name;
    private double calorie;
    private double protein;
    private double fat;
    private double carbohydrate;
    private Date date;
    private double amount;

    public GetFoodDTO(Food food) {
        this.setId(food.getId());
        this.setName(food.getName());
        this.setCalorie(food.getCalorie());
        this.setProtein(food.getProtein());
        this.setCarbohydrate(food.getCarbohydrate());
        this.setFat(food.getFat());
    }
    public GetFoodDTO(FoodDay foodDay) {
        this.setId(foodDay.getFood().getId());
        this.setName(foodDay.getFood().getName());
        this.setCalorie(foodDay.getFood().getCalorie());
        this.setProtein(foodDay.getFood().getProtein());
        this.setCarbohydrate(foodDay.getFood().getCarbohydrate());
        this.setFat(foodDay.getFood().getFat());
        this.setDate(foodDay.getAddedAt());
        this.setAmount(foodDay.getAmount());
    }

}
