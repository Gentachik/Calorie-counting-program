package arturnikytenko.calorieCountingProgram.Services;

import arturnikytenko.calorieCountingProgram.Models.Food;
import arturnikytenko.calorieCountingProgram.Models.FoodDTOs.GetFoodDTO;
import arturnikytenko.calorieCountingProgram.Models.UserDTOs.GetUserDTO;
import arturnikytenko.calorieCountingProgram.Models.UserModel;
import arturnikytenko.calorieCountingProgram.Repositories.FoodRepository;
import arturnikytenko.calorieCountingProgram.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ModelsService {
    private final UserRepository userRepository;
    private final FoodRepository foodRepository;

    @Autowired
    public ModelsService(UserRepository userRepository, FoodRepository foodRepository) {
        this.userRepository = userRepository;
        this.foodRepository = foodRepository;
    }

    public Optional<UserModel> findById(int id) {
        return userRepository.findById(id);
    }

    public GetUserDTO mapUserToGetDTO(UserModel userModel) {
        GetUserDTO userDTO = new GetUserDTO();
        userDTO.setFirstName(userModel.getFirstName());
        userDTO.setLastName(userModel.getLastName());
        userDTO.setEmail(userModel.getEmail());
        userDTO.setPassword(userModel.getPassword());
        userDTO.setAge(userModel.getAge());
        userDTO.setWeight(userModel.getWeight());
        userDTO.setHeight(userModel.getHeight());
        userDTO.setGoal(userModel.getGoal());
        userDTO.setTimeToReachGoal(userModel.getTimeToReachGoal());
        userDTO.setWeightToChange(userModel.getWeightToChange());
        userDTO.setGender(userModel.getGender());
        userDTO.setCreatedFoods(userModel.getCreatedFoods());
        userDTO.setDislikedFoods(userModel.getDislikedFoods());
        return userDTO;
    }

    public GetFoodDTO mapFoodToGetDTO(Food food) {
        GetFoodDTO foodDTO = new GetFoodDTO();
        foodDTO.setId(food.getId());
        foodDTO.setName(food.getName());
        foodDTO.setCalorie(food.getCalorie());
        foodDTO.setProtein(food.getProtein());
        foodDTO.setCarbohydrate(food.getCarbohydrate());
        foodDTO.setFat(food.getFat());
        return foodDTO;
    }

    public List<GetFoodDTO> findFoodBySearch(String search) {
        List<Food> foodList;
        List<GetFoodDTO> foodDTOList = new ArrayList<>();

        if (!search.isEmpty())
            foodList = foodRepository.findByNameContainingIgnoreCase(search);
        else
            foodList = (List<Food>) foodRepository.findAll();

        for (Food food : foodList)
            foodDTOList.add(this.mapFoodToGetDTO(food));
        return foodDTOList;
    }
}
