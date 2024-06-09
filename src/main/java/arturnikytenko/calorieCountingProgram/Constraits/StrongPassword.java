package arturnikytenko.calorieCountingProgram.Constraits;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StrongPasswordValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface StrongPassword {
    String message() default "Password must contain at least one uppercase letter, one lowercase letter, one special character, and no spaces";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
