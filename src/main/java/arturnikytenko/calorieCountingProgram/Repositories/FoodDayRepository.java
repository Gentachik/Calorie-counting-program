package arturnikytenko.calorieCountingProgram.Repositories;

import arturnikytenko.calorieCountingProgram.Models.FoodDay;
import arturnikytenko.calorieCountingProgram.Models.FoodDayKey;
import org.springframework.data.repository.CrudRepository;

public interface FoodDayRepository extends CrudRepository<FoodDay, FoodDayKey> {
}
