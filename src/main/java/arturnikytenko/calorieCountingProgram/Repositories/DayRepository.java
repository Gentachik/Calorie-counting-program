package arturnikytenko.calorieCountingProgram.Repositories;

import arturnikytenko.calorieCountingProgram.Models.DayModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface DayRepository extends CrudRepository<DayModel, Integer> {
    List<DayModel> findByDate(Date date);
}
