package arturnikytenko.calorieCountingProgram.Controllers.APIControllers;

import arturnikytenko.calorieCountingProgram.Models.UserDTOs.GetUserDTO;
import arturnikytenko.calorieCountingProgram.Models.UserModel;
import arturnikytenko.calorieCountingProgram.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserApiController {
    private final ProfileService profileService;

    @Autowired
    public UserApiController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserDTO> getUserById(@PathVariable int id) {
        Optional<UserModel> user = profileService.findById(id);
        if (user.isPresent()) {
            UserModel userModel = user.get();
            GetUserDTO userDTO = profileService.mapUserToGetDTO(userModel);
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
