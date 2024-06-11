package arturnikytenko.calorieCountingProgram.Models;

import arturnikytenko.calorieCountingProgram.Constraits.StrongPassword;
import arturnikytenko.calorieCountingProgram.Utilities.Goal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.Set;

//TODO connections
@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @StrongPassword
    private String password;

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

    private Date timeToReachGoal;

    @Min(value = 0, message = "This value should be positive")
    private double weightToChange;

    private String gender;

    @OneToMany(mappedBy = "creator")
    @JsonIgnore
    private Set<Food> createdFoods;

    @ManyToMany
    @JoinTable(
            name = "user_dislike",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    @JsonIgnore
    private Set<Food> dislikedFoods;

    public UserModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public Set<Food> getDislikedFoods() {
        return dislikedFoods;
    }

    public void setDislikedFoods(Set<Food> dislikedFoods) {
        this.dislikedFoods = dislikedFoods;
    }

    public Set<Food> getCreatedFoods() {
        return createdFoods;
    }

    public void setCreatedFoods(Set<Food> createdFoods) {
        this.createdFoods = createdFoods;
    }
}
