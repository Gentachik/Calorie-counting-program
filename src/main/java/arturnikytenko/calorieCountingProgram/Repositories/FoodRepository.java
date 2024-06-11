package arturnikytenko.calorieCountingProgram.Repositories;

import arturnikytenko.calorieCountingProgram.Models.Food;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodRepository extends CrudRepository<Food, Integer> {
    List<Food> findByNameContainingIgnoreCase(String search);
}
