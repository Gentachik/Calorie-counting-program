package arturnikytenko.calorieCountingProgram.Models.FoodDTOs;

import arturnikytenko.calorieCountingProgram.Models.FoodModel;

public class GetFoodDTO {
    private int id;
    private String name;
    private double calorie;
    private double protein;
    private double fat;
    private double carbohydrate;
    public GetFoodDTO (FoodModel foodModel) {
        this.setId(foodModel.getId());
        this.setName(foodModel.getName());
        this.setCalorie(foodModel.getCalorie());
        this.setProtein(foodModel.getProtein());
        this.setCarbohydrate(foodModel.getCarbohydrate());
        this.setFat(foodModel.getFat());
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
