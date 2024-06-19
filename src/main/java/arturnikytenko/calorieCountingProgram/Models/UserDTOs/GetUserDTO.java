package arturnikytenko.calorieCountingProgram.Models.UserDTOs;


import arturnikytenko.calorieCountingProgram.Models.Food;
import arturnikytenko.calorieCountingProgram.Models.UserModel;
import arturnikytenko.calorieCountingProgram.Utilities.Goal;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Setter
@Getter
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

}
