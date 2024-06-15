package arturnikytenko.calorieCountingProgram.Controllers.ApiControllers;

import arturnikytenko.calorieCountingProgram.Models.Food;
import arturnikytenko.calorieCountingProgram.Models.FoodDTOs.GetFoodDTO;
import arturnikytenko.calorieCountingProgram.Models.UserDTOs.GetUserDTO;
import arturnikytenko.calorieCountingProgram.Models.UserModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.Hibernate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    @Tag(name = "Get current user", description = "Get current authorized session user")
    @GetMapping("/get-current")
    public ResponseEntity<GetUserDTO> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserModel user = (UserModel) authentication.getPrincipal();

        Hibernate.initialize(user.getCreatedFoods());
        Hibernate.initialize(user.getDislikedFoods());

        GetUserDTO userDto = new GetUserDTO(user);
        return ResponseEntity.ok(userDto);
    }
    @Tag(name = "Get food dislikes", description = "Get current authorized session user food that he is marked as disliked")
    @GetMapping("/get-current-dislikes")
    public ResponseEntity<List<Integer>> getCurrentUserDislikes() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserModel user = (UserModel) authentication.getPrincipal();

        Hibernate.initialize(user.getCreatedFoods());
        Hibernate.initialize(user.getDislikedFoods());
        List<Integer> dislikes = new ArrayList<>();
        for (Food food : user.getDislikedFoods())
            dislikes.add(food.getId());

        return ResponseEntity.ok(dislikes);
    }
}
