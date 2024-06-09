package arturnikytenko.calorieCountingProgram.Services;

import arturnikytenko.calorieCountingProgram.Models.UserModel;
import arturnikytenko.calorieCountingProgram.Models.UserDTOs.RegisterUserDTO;
import arturnikytenko.calorieCountingProgram.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class RegisterService {
    private final UserRepository userRepository;

    @Autowired
    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public boolean isEmailExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public void save(RegisterUserDTO registerUserDTO, double weightToChange) {
        UserModel user = new UserModel();
        user.setEmail(registerUserDTO.getEmail());
        user.setPassword(registerUserDTO.getPassword());
        user.setFirstName(registerUserDTO.getFirstName());
        user.setLastName(registerUserDTO.getLastName());
        user.setAge(registerUserDTO.getAge());
        user.setGoal(registerUserDTO.getGoal());
        user.setHeight(registerUserDTO.getHeight());
        user.setWeight(registerUserDTO.getWeight());
        Date date = new Date();
        if (weightToChange != 0){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, (int) weightToChange);
            date = calendar.getTime();
            user.setWeightToChange(weightToChange);
        }else {
            user.setWeightToChange(0);
        }
        user.setTimeToReachGoal(date);
        userRepository.save(user);
    }
}
