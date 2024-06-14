package arturnikytenko.calorieCountingProgram.Controllers.ApiControllers;


import arturnikytenko.calorieCountingProgram.Models.FoodDTOs.GetFoodDTO;
import arturnikytenko.calorieCountingProgram.Services.ModelsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/food")
public class FoodApiController {
    private final ModelsService modelsService;

    @Autowired
    public FoodApiController(ModelsService modelsService) {
        this.modelsService = modelsService;
    }

    @Tag(name = "Get food by search", description = "Get food that matches search value")
    @GetMapping
    public ResponseEntity<List<GetFoodDTO>> getSearchResults(@RequestParam(name = "search") String search) {
        List<GetFoodDTO> foodDTOList = modelsService.findFoodBySearch(search);
        if (foodDTOList != null && !foodDTOList.isEmpty())
            return ResponseEntity.ok(foodDTOList);
        else
            return ResponseEntity.notFound().build();
    }
}