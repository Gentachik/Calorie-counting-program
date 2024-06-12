package arturnikytenko.calorieCountingProgram.Controllers.APIControllers;

import arturnikytenko.calorieCountingProgram.Models.UserDTOs.GetUserDTO;
import arturnikytenko.calorieCountingProgram.Models.UserModel;
import arturnikytenko.calorieCountingProgram.Services.ModelsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserApiController {
    private final ModelsService modelsService;

    @Autowired
    public UserApiController(ModelsService modelsService) {
        this.modelsService = modelsService;
    }

    @Tag(name = "Get user", description = "Get user by id")
    @GetMapping("/{id}")
    public ResponseEntity<GetUserDTO> getUserById(@PathVariable int id) {
        Optional<UserModel> user = modelsService.findUserById(id);
        if (user.isPresent()) {
            UserModel userModel = user.get();
            GetUserDTO userDTO = modelsService.mapUserToGetDTO(userModel);
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
