package arturnikytenko.calorieCountingProgram.Services;


import arturnikytenko.calorieCountingProgram.Models.Food;
import arturnikytenko.calorieCountingProgram.Models.FoodDTOs.CreateFoodDto;
import arturnikytenko.calorieCountingProgram.Models.FoodDTOs.GetFoodDTO;
import arturnikytenko.calorieCountingProgram.Models.UserModel;
import arturnikytenko.calorieCountingProgram.Repositories.FoodRepository;
import arturnikytenko.calorieCountingProgram.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    private final UserRepository userRepository;
    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(UserRepository userRepository, FoodRepository foodRepository) {
        this.userRepository = userRepository;
        this.foodRepository = foodRepository;
    }

    @Transactional
    public void saveNewFood(int userId, CreateFoodDto foodDto) {
        UserModel user = userRepository.findById(userId).orElse(null);
        Food food = new Food(user, foodDto.getCarbohydrate(), foodDto.getCalorie(), foodDto.getProtein(), foodDto.getFat(), foodDto.getName());
        foodRepository.save(food);
    }
    @Transactional
    public void save(Food food) {
        foodRepository.save(food);
    }
    public List<GetFoodDTO> findFoodBySearch(String search) {
        List<Food> foodList;
        List<GetFoodDTO> foodDTOList = new ArrayList<>();

        if (!search.isEmpty())
            foodList = foodRepository.findByNameContainingIgnoreCase(search);
        else
            foodList = (List<Food>) foodRepository.findAll();

        for (Food food : foodList)
            foodDTOList.add(new GetFoodDTO(food));
        return foodDTOList;
    }
    public Optional<Food> findFoodById(int id) {
        return foodRepository.findById(id);
    }

}
