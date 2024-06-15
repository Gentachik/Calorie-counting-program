package arturnikytenko.calorieCountingProgram.Controllers;

import arturnikytenko.calorieCountingProgram.Models.FoodDTOs.CreateFoodDto;
import arturnikytenko.calorieCountingProgram.Models.UserModel;
import arturnikytenko.calorieCountingProgram.Services.FoodService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/profile")
public class ProfileController {
    private final FoodService foodService;

    @Autowired
    public ProfileController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public ModelAndView profile(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserModel currentUser = (UserModel) authentication.getPrincipal();
        model.addAttribute("user", currentUser);
        return new ModelAndView("profile");
    }

    @GetMapping("/newFood")
    public ModelAndView getNewFood(Model model) {
        model.addAttribute("foodModel", new CreateFoodDto());
        return new ModelAndView("newFood");
    }
    @PostMapping("/newFood")
    public ModelAndView postNewFood(@ModelAttribute("food") @Valid CreateFoodDto foodDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserModel currentUser = (UserModel) authentication.getPrincipal();
        foodService.saveNewFood(currentUser.getId(), foodDto);
        return new ModelAndView("redirect:/profile");
    }

}
