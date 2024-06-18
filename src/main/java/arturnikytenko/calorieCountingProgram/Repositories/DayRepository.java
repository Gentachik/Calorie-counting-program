package arturnikytenko.calorieCountingProgram.Repositories;

import arturnikytenko.calorieCountingProgram.Models.DayModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DayRepository extends CrudRepository<DayModel, Integer> {
    Optional<DayModel> findByDate(String date);
}
