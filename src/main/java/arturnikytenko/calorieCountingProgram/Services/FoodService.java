package arturnikytenko.calorieCountingProgram.Services;


import arturnikytenko.calorieCountingProgram.Models.FoodModel;
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
        FoodModel foodModel = new FoodModel(user, foodDto.getCarbohydrate(), foodDto.getCalorie(), foodDto.getProtein(), foodDto.getFat(), foodDto.getName());
        foodRepository.save(foodModel);
    }
    @Transactional
    public void save(FoodModel foodModel) {
        foodRepository.save(foodModel);
    }
    public List<GetFoodDTO> findFoodBySearch(String search) {
        List<FoodModel> foodModelList;
        List<GetFoodDTO> foodDTOList = new ArrayList<>();

        if (!search.isEmpty())
            foodModelList = foodRepository.findByNameContainingIgnoreCase(search);
        else
            foodModelList = (List<FoodModel>) foodRepository.findAll();

        for (FoodModel foodModel : foodModelList)
            foodDTOList.add(new GetFoodDTO(foodModel));
        return foodDTOList;
    }
    public Optional<FoodModel> findFoodById(int id) {
        return foodRepository.findById(id);
    }

}
