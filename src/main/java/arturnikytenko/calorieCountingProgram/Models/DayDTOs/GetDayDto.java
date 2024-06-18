package arturnikytenko.calorieCountingProgram.Models.DayDTOs;

import arturnikytenko.calorieCountingProgram.Models.DayModel;
import arturnikytenko.calorieCountingProgram.Models.FoodDTOs.GetFoodDTO;

import java.util.Date;
import java.util.List;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<GetFoodDTO> getFoods() {
        return foods;
    }

    public void setFoods(List<GetFoodDTO> foods) {
        this.foods = foods;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }
}
