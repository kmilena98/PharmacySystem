package ISA.Team54.drugAndRecipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team54.drugAndRecipe.dto.DrugDTO;
import ISA.Team54.drugAndRecipe.dto.IngredientDTO;
import ISA.Team54.drugAndRecipe.mapper.DrugMapper;
import ISA.Team54.drugAndRecipe.mapper.IngredientMapper;
import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.model.Ingredient;
import ISA.Team54.drugAndRecipe.service.interfaces.DrugService;
import ISA.Team54.drugAndRecipe.service.interfaces.IngredientService;

@RestController
@RequestMapping(value = "/ingredients", produces = MediaType.APPLICATION_JSON_VALUE)
public class IngredientController {
	@Autowired
	private IngredientService ingredientService;
	
	@PostMapping("/addIngredient")
	@PreAuthorize("hasRole('SYSTEM_ADMIN')")
	public  ResponseEntity<Ingredient> addDrug(@RequestBody IngredientDTO ingredientDTO){
		return new ResponseEntity<>(ingredientService.addIngredient(IngredientMapper.IngredientDTOTOIngredient(ingredientDTO)), HttpStatus.OK);	
	}
}
