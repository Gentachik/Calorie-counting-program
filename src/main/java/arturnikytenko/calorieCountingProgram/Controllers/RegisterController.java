package arturnikytenko.calorieCountingProgram.Controllers;

import arturnikytenko.calorieCountingProgram.Models.UserDTOs.PreRegisterUserDTO;
import arturnikytenko.calorieCountingProgram.Models.UserDTOs.RegisterUserDTO;
import arturnikytenko.calorieCountingProgram.Services.RegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@Controller
public class RegisterController {
    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/preRegister")
    public String preRegistrationForm(Model model) {
        model.addAttribute("preRegisterUserDTO", new PreRegisterUserDTO());
        return "preRegister";
    }

    @PostMapping("/preRegister")
    public String preRegistrationForm(@Valid @ModelAttribute("preRegisterUserDTO") PreRegisterUserDTO preRegisterUserDTO,
                                      BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (registerService.isEmailExist(preRegisterUserDTO.getEmail()))
            bindingResult.rejectValue("email", "error.preRegisterUserDTO", "This email already exists!");

        if (!Objects.equals(preRegisterUserDTO.getPassword(), preRegisterUserDTO.getRepeatPassword()))
            bindingResult.rejectValue("password", "error.preRegisterUserDTO", "Passwords do not match!");

        if (bindingResult.hasErrors()) {
            return "preRegister";
        }
        redirectAttributes.addFlashAttribute("email", preRegisterUserDTO.getEmail());
        redirectAttributes.addFlashAttribute("password", preRegisterUserDTO.getPassword());

        return "redirect:/register";
    }

    @GetMapping("/register")
    public String registrationForm(Model model,
                                   @ModelAttribute("email") String email,
                                   @ModelAttribute("password") String password) {
        RegisterUserDTO registerUserDTO = new RegisterUserDTO();
        registerUserDTO.setEmail(email);
        registerUserDTO.setPassword(password);
        model.addAttribute("registerUserDTO", registerUserDTO);
        return "register";
    }

    @PostMapping("/register")
    public String registrationForm(@Valid @ModelAttribute("registerUserDTO") RegisterUserDTO registerUserDTO,
                                   @RequestParam(value = "weightToChange", required = false, defaultValue = "0") double weightToChange,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        registerService.save(registerUserDTO, weightToChange);
        return "redirect:/preRegister";
    }
}
