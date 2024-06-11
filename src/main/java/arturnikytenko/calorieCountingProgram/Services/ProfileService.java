package arturnikytenko.calorieCountingProgram.Services;

import arturnikytenko.calorieCountingProgram.Models.Food;
import arturnikytenko.calorieCountingProgram.Models.UserModel;
import arturnikytenko.calorieCountingProgram.Repositories.FoodRepository;
import arturnikytenko.calorieCountingProgram.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
    private final UserRepository userRepository;
    private final FoodRepository foodRepository;

    @Autowired
    public ProfileService(UserRepository userRepository, FoodRepository foodRepository) {
        this.userRepository = userRepository;
        this.foodRepository = foodRepository;
    }

    public Optional<UserModel> findById(int id) {
        return userRepository.findById(id);
    }

    @Transactional
    public void saveFood(int userId, String name, double calorie, double protein, double fat, double carbohydrate) {
        UserModel user = userRepository.findById(userId).orElse(null);
        Food food = new Food(user, carbohydrate, calorie, protein, fat, name);
        foodRepository.save(food);
    }
}
