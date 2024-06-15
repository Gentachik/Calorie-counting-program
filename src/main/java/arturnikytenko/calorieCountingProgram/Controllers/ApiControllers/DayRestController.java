package arturnikytenko.calorieCountingProgram.Controllers.ApiControllers;

import arturnikytenko.calorieCountingProgram.Models.DayDTOs.GetDayDto;
import arturnikytenko.calorieCountingProgram.Models.DayModel;
import arturnikytenko.calorieCountingProgram.Models.UserModel;
import arturnikytenko.calorieCountingProgram.Services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/day")
public class DayRestController {
    private final DayService dayService;

    @Autowired
    public DayRestController(DayService dayService) {
        this.dayService = dayService;
    }

    @GetMapping("/day")
    public ResponseEntity<?> a(@RequestParam(name = "date", required = true) String strDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
            Date date = sdf.parse(strDate);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserModel currentUser = (UserModel) authentication.getPrincipal();
            DayModel day = dayService.getDayByDate(date, currentUser);
            GetDayDto getDay = new GetDayDto(day);
            return ResponseEntity.ok(getDay);
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
