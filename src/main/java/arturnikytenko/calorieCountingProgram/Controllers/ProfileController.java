package arturnikytenko.calorieCountingProgram.Controllers;


import arturnikytenko.calorieCountingProgram.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{id}")
    public String profile(@PathVariable int id) {
        return "profile";
    }

    @GetMapping("/{id}/newFood")
    public String getNewFood(@PathVariable int id) {
        return "newFood";
    }

    @PostMapping("/{id}/newFood")
    public String postNewFood(@PathVariable int id,
                              @RequestParam("name") String name,
                              @RequestParam(value = "calorie", defaultValue = "0") double calorie,
                              @RequestParam(value = "protein", defaultValue = "0") double protein,
                              @RequestParam(value = "fat", defaultValue = "0") double fat,
                              @RequestParam(value = "carbohydrate", defaultValue = "0") double carbohydrate) {
        profileService.saveFood(id, name, calorie, protein, fat, carbohydrate);
        return "redirect:/profile/" + id;
    }
}
