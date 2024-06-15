package arturnikytenko.calorieCountingProgram.Repositories;

import arturnikytenko.calorieCountingProgram.Models.DayModel;
import org.springframework.data.repository.CrudRepository;

public interface DayRepository extends CrudRepository<DayModel, Integer> {
}
