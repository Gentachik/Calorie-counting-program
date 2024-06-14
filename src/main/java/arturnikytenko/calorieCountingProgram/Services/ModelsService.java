package arturnikytenko.calorieCountingProgram.Services;


import arturnikytenko.calorieCountingProgram.Models.Food;
import arturnikytenko.calorieCountingProgram.Models.FoodDTOs.GetFoodDTO;
import arturnikytenko.calorieCountingProgram.Repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ModelsService {
    private final FoodRepository foodRepository;

    @Autowired
    public ModelsService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
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

    public Optional<Food> findFoodById(int id) {
        return foodRepository.findById(id);
    }
}
