package arturnikytenko.calorieCountingProgram.Services;

import arturnikytenko.calorieCountingProgram.Models.DayModel;
import arturnikytenko.calorieCountingProgram.Models.UserModel;
import arturnikytenko.calorieCountingProgram.Repositories.DayRepository;
import arturnikytenko.calorieCountingProgram.Repositories.FoodDayRepository;
import arturnikytenko.calorieCountingProgram.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DayService {
    private final DayRepository dayRepository;
    private final UserRepository userRepository;
    private final FoodDayRepository repositories;

    @Autowired
    public DayService(DayRepository dayRepository, UserRepository userRepository, FoodDayRepository repositories) {
        this.dayRepository = dayRepository;
        this.userRepository = userRepository;
        this.repositories = repositories;
    }

    public DayModel getDayByDate(Date date, UserModel user) {
        List<DayModel> dayModels = dayRepository.findByDate(date);
        if (!dayModels.isEmpty()) {
            for (DayModel dayModel : dayModels) {
                if (dayModel.getCreator().equals(user))
                    return dayModel;
            }
        }
        DayModel dayModel = new DayModel(user);
        dayRepository.save(dayModel);
        return dayModel;
    }
}
