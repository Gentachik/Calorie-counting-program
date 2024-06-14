package arturnikytenko.calorieCountingProgram.Controllers.ApiControllers;

import arturnikytenko.calorieCountingProgram.Models.UserDTOs.GetUserDTO;
import arturnikytenko.calorieCountingProgram.Models.UserModel;
import org.hibernate.Hibernate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    @GetMapping("/get-current")
    public ResponseEntity<GetUserDTO> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserModel user = (UserModel) authentication.getPrincipal();

        Hibernate.initialize(user.getCreatedFoods());

        GetUserDTO userDto = new GetUserDTO(user);
        return ResponseEntity.ok(userDto);
    }
}
