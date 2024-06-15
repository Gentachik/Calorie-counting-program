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
public class UserService {
    private final UserRepository userRepository;
    private final FoodRepository foodRepository;

    @Autowired
    public UserService(UserRepository userRepository, FoodRepository foodRepository) {
        this.userRepository = userRepository;
        this.foodRepository = foodRepository;
    }

    @Transactional
    public void save(UserModel user) {
        userRepository.save(user);
    }

    @Transactional
    public void removeFoodById(UserModel user, int foodId) {
        Optional<Food> food = foodRepository.findById(foodId);
        if (food.isPresent()) {
            user.getDislikedFoods().remove(food.get());
            userRepository.save(user);
        }
    }

    @Transactional
    public void addFoodById(UserModel user, int foodId) {
        Optional<Food> food = foodRepository.findById(foodId);
        if (food.isPresent()) {
            user.getDislikedFoods().add(food.get());
            userRepository.save(user);
        }
    }
}
