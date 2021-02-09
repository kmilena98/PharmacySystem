package ISA.Team54.drugAndRecipe.mapper;

import ISA.Team54.drugAndRecipe.dto.IngredientDTO;
import ISA.Team54.drugAndRecipe.model.Ingredient;

public class IngredientMapper {
	
	public static Ingredient IngredientDTOTOIngredient(IngredientDTO ingredientDTO) {
		Ingredient ingredient = new Ingredient(ingredientDTO.getIngredient());
		ingredient.setId(ingredientDTO.getId());
		return ingredient;
	}
	
}
