package arturnikytenko.calorieCountingProgram.Models.FoodDTOs;

import arturnikytenko.calorieCountingProgram.Models.Food;

public class GetFoodDTO {
    private int id;
    private String name;
    private double calorie;
    private double protein;
    private double fat;
    private double carbohydrate;

    public GetFoodDTO(Food food) {
        this.setId(food.getId());
        this.setName(food.getName());
        this.setCalorie(food.getCalorie());
        this.setProtein(food.getProtein());
        this.setCarbohydrate(food.getCarbohydrate());
        this.setFat(food.getFat());
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
}
