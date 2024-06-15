package arturnikytenko.calorieCountingProgram.Controllers.ApiControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/day")
public class DayController {
    public DayController() {
    }

    @GetMapping
    public ModelAndView viewDays(Model model) {
        return new ModelAndView("chooseDay");
    }
}
