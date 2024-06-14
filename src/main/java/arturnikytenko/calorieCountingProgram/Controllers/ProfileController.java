package arturnikytenko.calorieCountingProgram.Controllers;

import arturnikytenko.calorieCountingProgram.Models.UserModel;
import arturnikytenko.calorieCountingProgram.Services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView getNewFood() {
        return new ModelAndView("newFood");
    }
    @PostMapping("/newFood")
    public ModelAndView postNewFood(@RequestParam("name") String name,
                              @RequestParam(value = "calorie", defaultValue = "0") double calorie,
                              @RequestParam(value = "protein", defaultValue = "0") double protein,
                              @RequestParam(value = "fat", defaultValue = "0") double fat,
                              @RequestParam(value = "carbohydrate", defaultValue = "0") double carbohydrate) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserModel currentUser = (UserModel) authentication.getPrincipal();
        foodService.saveFood(currentUser.getId(), name, calorie, protein, fat, carbohydrate);
        return new ModelAndView("redirect:/profile");
    }
}
