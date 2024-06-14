package arturnikytenko.calorieCountingProgram.Models.UserDTOs;


import arturnikytenko.calorieCountingProgram.Utilities.Goal;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;

public class RegisterUserDto {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    @Min(18)
    private int age;
    @NotNull
    @Min(1)
    @Max(1000)
    private double weight;
    @NotNull
    @Min(1)
    @Max(300)
    private double height;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Goal goal;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    @Min(value = 0, message = "This value should be positive")
    private Double weightToChange = 0.0;

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

    public Double  getWeightToChange() {
        return weightToChange;
    }

    public void setWeightToChange(Double weightToChange) {
        this.weightToChange = weightToChange != null ? weightToChange : 0.0;
    }
}
