package arturnikytenko.calorieCountingProgram.Controllers;


import arturnikytenko.calorieCountingProgram.Models.UserDTOs.RegisterUserDto;
import arturnikytenko.calorieCountingProgram.Services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    private final AuthenticationService authenticationService;

    @Autowired
    public RegisterController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @GetMapping("/signup")
    public String register(Model model){
        model.addAttribute("registerUserDTO", new RegisterUserDto());
        return "register";
    }
    @PostMapping("/signup")
    public ModelAndView register(@ModelAttribute("registerUserDTO") @Valid RegisterUserDto registerUserDto) {
        authenticationService.signup(registerUserDto);

        return new ModelAndView("redirect:/login");
    }
}
