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
    private double bmr;
    private double tdee;
    private Date date;
    private List<GetFoodDTO> foods;

    public GetDayDto(DayModel day) {
        date = day.getDate();
        neededCalorie = day.getNeededCalorie();
        neededProtein = day.getNeededProtein();
        neededCarbohydrate = day.getNeededCarbohydrate();
        neededFat = day.getNeededFat();
        bmr = day.getBMR();
        tdee = day.getTDEE();
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<GetFoodDTO> getFoods() {
        return foods;
    }

    public void setFoods(List<GetFoodDTO> foods) {
        this.foods = foods;
    }

    public double getBmr() {
        return bmr;
    }

    public void setBmr(double bmr) {
        this.bmr = bmr;
    }

    public double getTdee() {
        return tdee;
    }

    public void setTdee(double tdee) {
        this.tdee = tdee;
    }
}
