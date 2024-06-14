package arturnikytenko.calorieCountingProgram.Services;




import arturnikytenko.calorieCountingProgram.Models.UserDTOs.LoginUserDTO;
import arturnikytenko.calorieCountingProgram.Models.UserDTOs.RegisterUserDto;
import arturnikytenko.calorieCountingProgram.Models.UserModel;
import arturnikytenko.calorieCountingProgram.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void signup(RegisterUserDto input) {
        UserModel user = new UserModel();
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setAge(input.getAge());
        user.setWeight(input.getWeight());
        user.setHeight(input.getHeight());
        user.setGoal(input.getGoal());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        userRepository.save(user);
    }

    public UserModel authenticate(LoginUserDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
