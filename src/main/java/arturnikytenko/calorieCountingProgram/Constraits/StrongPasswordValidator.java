package arturnikytenko.calorieCountingProgram.Constraits;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StrongPasswordValidator implements
        ConstraintValidator<StrongPassword, String> {

    @Override
    public void initialize(StrongPassword contactNumber) {
    }

    @Override
    public boolean isValid(String password,
                           ConstraintValidatorContext cxt) {
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z\\d])(?=\\S+$).{8,}$";
        return password.matches(passwordPattern);
    }

}
