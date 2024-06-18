package arturnikytenko.calorieCountingProgram.Controllers;

import arturnikytenko.calorieCountingProgram.Models.UserModel;
import arturnikytenko.calorieCountingProgram.Services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public String seeFoods() {
        return "food/foods";
    }

    @GetMapping("{id}")
    public String seeFood(@PathVariable int id, Model model) {
        if (foodService.findFoodById(id).isPresent()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserModel currentUser = (UserModel) authentication.getPrincipal();
            model.addAttribute("food", foodService.findFoodById(id).get());
            model.addAttribute("user", currentUser);
        } else
            return "error";
        return "food/food";
    }
}