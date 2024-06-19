package arturnikytenko.calorieCountingProgram.Models.UserDTOs;


import arturnikytenko.calorieCountingProgram.Utilities.Goal;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    public void setWeightToChange(Double weightToChange) {
        this.weightToChange = weightToChange != null ? weightToChange : 0.0;
    }
}
