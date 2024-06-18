package arturnikytenko.calorieCountingProgram.Controllers;

import arturnikytenko.calorieCountingProgram.Models.UserDTOs.LoginUserDTO;
import arturnikytenko.calorieCountingProgram.Models.UserModel;
import arturnikytenko.calorieCountingProgram.Services.AuthenticationService;
import arturnikytenko.calorieCountingProgram.Services.JwtService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    @Autowired
    public LoginController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginUserDto", new LoginUserDTO());
        return "auth/login";
    }

    @PostMapping("/login")
    public ModelAndView  login(@ModelAttribute("loginUserDto") LoginUserDTO loginUserDTO, HttpServletResponse response) {

        UserModel user = authenticationService.authenticate(loginUserDTO);
        if (user == null){
            return new ModelAndView("redirect:/error");
        }
        String jwtToken = jwtService.generateToken(user);
        ResponseCookie.ResponseCookieBuilder cookieBuilder = ResponseCookie
                .from("token", jwtToken)
                .httpOnly(true)
                .secure(false)
                .path("/")
                .sameSite("Strict")
                .maxAge(jwtService.getExpirationTime()/1000);

        response.addHeader(HttpHeaders.SET_COOKIE, cookieBuilder.build().toString());

        return new ModelAndView("redirect:/profile");
    }
}