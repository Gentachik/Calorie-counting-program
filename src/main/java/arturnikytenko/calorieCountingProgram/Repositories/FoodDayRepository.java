package arturnikytenko.calorieCountingProgram.Repositories;

import arturnikytenko.calorieCountingProgram.Models.DayModel;
import arturnikytenko.calorieCountingProgram.Models.FoodDay;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodDayRepository extends CrudRepository<FoodDay, Integer> {
    List<FoodDay> findByDay(DayModel day);

}
