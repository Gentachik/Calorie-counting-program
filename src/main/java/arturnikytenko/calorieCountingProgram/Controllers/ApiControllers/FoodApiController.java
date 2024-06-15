package arturnikytenko.calorieCountingProgram.Controllers.ApiControllers;


import arturnikytenko.calorieCountingProgram.Models.Food;
import arturnikytenko.calorieCountingProgram.Models.FoodDTOs.GetFoodDTO;
import arturnikytenko.calorieCountingProgram.Models.UserModel;
import arturnikytenko.calorieCountingProgram.Services.FoodService;
import arturnikytenko.calorieCountingProgram.Services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/food")
public class FoodApiController {

    private final FoodService foodService;
    private final UserService userService;

    @Autowired
    public FoodApiController(FoodService foodService, UserService userService) {
        this.foodService = foodService;
        this.userService = userService;
    }

    @Tag(name = "Get food by search", description = "Get food that matches search value")
    @GetMapping
    public ResponseEntity<List<GetFoodDTO>> getSearchResults(@RequestParam(name = "search") String search) {
        List<GetFoodDTO> foodDTOList = foodService.findFoodBySearch(search);
        if (foodDTOList != null && !foodDTOList.isEmpty()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserModel user = (UserModel) authentication.getPrincipal();
            Set<Integer> dislikedFoodIds = user.getDislikedFoods().stream()
                    .map(Food::getId)
                    .collect(Collectors.toSet());

            List<GetFoodDTO> filteredFoodDTOList = foodDTOList.stream()
                    .filter(foodDTO -> !dislikedFoodIds.contains(foodDTO.getId()))
                    .toList();

            if (!filteredFoodDTOList.isEmpty()) {
                return ResponseEntity.ok(filteredFoodDTOList);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else
            return ResponseEntity.notFound().build();
    }

    @Tag(name = "Change food preference", description = "Change food preference of current user")
    @PostMapping("/{id}/preference")
    public ResponseEntity<?> changePreference(@PathVariable("id") int id) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserModel user = (UserModel) authentication.getPrincipal();
            Hibernate.initialize(user.getDislikedFoods());

            boolean isDisliked = false;

            for (Food f : user.getDislikedFoods()) {
                if (f.getId() == id) {
                    isDisliked = true;
                    break;
                }
            }
            if (isDisliked) {
                userService.removeFoodById(user, id);
                return ResponseEntity.ok(true);
            } else {
                userService.addFoodById(user, id);
                return ResponseEntity.ok(false);
            }
    }
}