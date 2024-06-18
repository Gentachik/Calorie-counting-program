package arturnikytenko.calorieCountingProgram.Models.FoodDTOs;

import arturnikytenko.calorieCountingProgram.Models.Food;
import arturnikytenko.calorieCountingProgram.Models.FoodDay;

import java.util.Date;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
