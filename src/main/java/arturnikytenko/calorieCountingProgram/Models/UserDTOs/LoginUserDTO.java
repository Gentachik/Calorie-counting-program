package arturnikytenko.calorieCountingProgram.Models.UserDTOs;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginUserDTO {
    private String email;
    private String password;

}
