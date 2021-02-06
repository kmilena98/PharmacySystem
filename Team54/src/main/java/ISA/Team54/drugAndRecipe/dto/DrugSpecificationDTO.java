package ISA.Team54.drugAndRecipe.dto;

import java.util.List;
import java.util.Set;

import ISA.Team54.drugAndRecipe.model.Contraindication;
import ISA.Team54.drugAndRecipe.model.Ingredient;

public class DrugSpecificationDTO {
	private List<Contraindication> contraindication;
	private List<Ingredient> ingredients;
	private String suggestedDose;
	public DrugSpecificationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DrugSpecificationDTO(List<Contraindication> contraindication, List<Ingredient> ingredients,
			String suggestedDose) {
		super();
		this.contraindication = contraindication;
		this.ingredients = ingredients;
		this.suggestedDose = suggestedDose;
	}

	public List<Contraindication> getContraindication() {
		return contraindication;
	}
	public void setContraindication(List<Contraindication> contraindication) {
		this.contraindication = contraindication;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public String getSuggestedDose() {
		return suggestedDose;
	}
	public void setSuggestedDose(String suggestedDose) {
		this.suggestedDose = suggestedDose;
	}
	
	
}
