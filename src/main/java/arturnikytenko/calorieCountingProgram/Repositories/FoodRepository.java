package arturnikytenko.calorieCountingProgram.Repositories;

import arturnikytenko.calorieCountingProgram.Models.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Integer> {
}
