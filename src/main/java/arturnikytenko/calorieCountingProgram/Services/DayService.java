package arturnikytenko.calorieCountingProgram.Services;

import arturnikytenko.calorieCountingProgram.Models.*;
import arturnikytenko.calorieCountingProgram.Models.FoodDTOs.GetFoodDTO;
import arturnikytenko.calorieCountingProgram.Repositories.DayRepository;
import arturnikytenko.calorieCountingProgram.Repositories.FoodDayRepository;
import arturnikytenko.calorieCountingProgram.Repositories.FoodRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DayService {
    private final DayRepository dayRepository;
    private final FoodDayRepository foodDayRepository;
    private final FoodRepository foodRepository;

    @Autowired
    public DayService(DayRepository dayRepository, FoodDayRepository foodDayRepository, FoodRepository foodRepository) {
        this.dayRepository = dayRepository;
        this.foodDayRepository = foodDayRepository;
        this.foodRepository = foodRepository;
    }

    @Transactional
    public DayModel getDayByDate(String date, UserModel user) {
        Optional<DayModel> optDayModel = dayRepository.findByDate(date);
        if (optDayModel.isPresent()) {
            if (optDayModel.get().getCreator().equals(user))
                return optDayModel.get();
        }
        DayModel dayModel = new DayModel(user);
        dayRepository.save(dayModel);
        return dayModel;

    }

    @Transactional
    public void addFoodToDay(int foodId, DayModel day, double amount) {
        Optional<Food> food = foodRepository.findById(foodId);
        if (food.isPresent()) {
            FoodDay foodDay = new FoodDay();
            foodDay.setDay(day);
            foodDay.setFood(food.get());
            foodDay.setAmount(amount);
            foodDay.setAddedAt(new Date());

            day.getFoodDays().add(foodDay);
            food.get().getFoodDays().add(foodDay);

            foodDayRepository.save(foodDay);
            //foodRepository.save(food.get());
            //dayRepository.save(day);
        }
    }

    public List<GetFoodDTO> getFoodsForDay(DayModel day) {
        List<DayModel> dayModels = (List<DayModel>) dayRepository.findAll();

        List<GetFoodDTO> foods = new ArrayList<>();
        for (FoodDay foodDay : foodDayRepository.findAll()) {
            if (foodDay.getDay().equals(day)) {
                foods.add(new GetFoodDTO(foodDay));
            }
        }

        return foods;
    }
}
