package arturnikytenko.calorieCountingProgram.Repositories;

import arturnikytenko.calorieCountingProgram.Models.FoodModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodRepository extends CrudRepository<FoodModel, Integer> {
    List<FoodModel> findByNameContainingIgnoreCase(String search);
}
