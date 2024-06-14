package arturnikytenko.calorieCountingProgram.Controllers;

import arturnikytenko.calorieCountingProgram.Services.ModelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/food")
public class FoodController {

    private final ModelsService modelsService;

    @Autowired
    public FoodController(ModelsService modelsService) {
        this.modelsService = modelsService;
    }

    @GetMapping
    public String seeFoods(){
        return "foods";
    }
    @GetMapping("{id}")
    public String seeFood(@PathVariable int id, Model model){
        if (modelsService.findFoodById(id).isPresent())
            model.addAttribute("food", modelsService.findFoodById(id).get());
        else
            return "error";
        return "food";
    }
}