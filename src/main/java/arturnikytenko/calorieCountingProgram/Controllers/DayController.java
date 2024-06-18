package arturnikytenko.calorieCountingProgram.Controllers;


import arturnikytenko.calorieCountingProgram.Models.DayDTOs.GetDayDto;
import arturnikytenko.calorieCountingProgram.Models.DayModel;
import arturnikytenko.calorieCountingProgram.Models.UserModel;
import arturnikytenko.calorieCountingProgram.Repositories.UserRepository;
import arturnikytenko.calorieCountingProgram.Services.DayService;
import arturnikytenko.calorieCountingProgram.Services.FoodService;
import arturnikytenko.calorieCountingProgram.Services.UserService;
import arturnikytenko.calorieCountingProgram.Utilities.GlobalVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/day")
public class DayController {
    private final DayService dayService;
    private final FoodService foodService;
    private final UserRepository userRepository;

    @Autowired
    public DayController(DayService dayService, FoodService foodService, UserRepository userRepository) {
        this.dayService = dayService;
        this.foodService = foodService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ModelAndView viewDays() {
        return new ModelAndView("day/days");
    }

    @GetMapping("/day")
    public ModelAndView viewDays(@RequestParam(name = "date", required = true) String date) {
        ModelAndView view = new ModelAndView("day/day");
        view.addObject("date", date);
        return view;
    }

    @GetMapping("/day/add-food")
    public ModelAndView viewAddFood() {
        return new ModelAndView("day/addFood");
    }

    @GetMapping("/add-food/{id}")
    public ModelAndView viewAddFood(Model model, @PathVariable(name = "id") int foodId,
                                    @RequestParam(name = "date") String strDate) {
        ModelAndView view = new ModelAndView("day/chosenDay");
        if (foodService.findFoodById(foodId).isPresent()) {
            model.addAttribute("food", foodService.findFoodById(foodId).get());
            view.addObject("date", strDate);
        } else
            view.setViewName("day/addFood");
        return view;
    }

    @PostMapping("/add-food/{id}")
    public ModelAndView addFood(@PathVariable(name = "id") int foodId,
                                @RequestParam("amount") double amount,
                                @RequestParam(name = "date") String strDate) {
        ModelAndView view = new ModelAndView("redirect:/day/day?date=" + strDate);

        view.addObject("date", strDate);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserModel currentUser = (UserModel) authentication.getPrincipal();
        DayModel day = dayService.getDayByDate(strDate, currentUser);
        dayService.addFoodToDay(foodId, day, amount);
        return view;
    }
}