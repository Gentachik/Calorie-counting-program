package arturnikytenko.calorieCountingProgram.Models.UserDTOs;


import arturnikytenko.calorieCountingProgram.Models.Food;
import arturnikytenko.calorieCountingProgram.Models.UserModel;
import arturnikytenko.calorieCountingProgram.Utilities.Goal;

import java.util.Date;
import java.util.Set;

public class GetUserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int age;
    private double weight;
    private double height;
    private Goal goal;
    private Date timeToReachGoal;
    private double weightToChange;
    private String gender;
    private Set<Food> createdFoods;
    private Set<Food> dislikedFoods;

    public GetUserDTO(UserModel userModel) {
        this.firstName = userModel.getFirstName();
        this.lastName = userModel.getLastName();
        this.email = userModel.getEmail();
        this.password = userModel.getPassword();
        this.age = userModel.getAge();
        this.weight = userModel.getWeight();
        this.height = userModel.getHeight();
        this.goal = userModel.getGoal();
        this.timeToReachGoal = userModel.getTimeToReachGoal();
        this.weightToChange = userModel.getWeightToChange();
        this.gender = userModel.getGender();
        this.createdFoods = userModel.getCreatedFoods();
        this.dislikedFoods = userModel.getDislikedFoods();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public Date getTimeToReachGoal() {
        return timeToReachGoal;
    }

    public void setTimeToReachGoal(Date timeToReachGoal) {
        this.timeToReachGoal = timeToReachGoal;
    }

    public double getWeightToChange() {
        return weightToChange;
    }

    public void setWeightToChange(double weightToChange) {
        this.weightToChange = weightToChange;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<Food> getCreatedFoods() {
        return createdFoods;
    }

    public void setCreatedFoods(Set<Food> createdFoods) {
        this.createdFoods = createdFoods;
    }

    public Set<Food> getDislikedFoods() {
        return dislikedFoods;
    }

    public void setDislikedFoods(Set<Food> dislikedFoods) {
        this.dislikedFoods = dislikedFoods;
    }
}
