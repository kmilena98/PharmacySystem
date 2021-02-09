package ISA.Team54.drugAndRecipe.dto;

public class IngredientDTO {
	
	private long id;
	private String ingredient;
	
	public IngredientDTO() {
		super();
	}
	
	public IngredientDTO(long id, String ingredient) {
		super();
		this.id = id;
		this.ingredient = ingredient;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the ingredient
	 */
	public String getIngredient() {
		return ingredient;
	}

	/**
	 * @param ingredient the ingredient to set
	 */
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	
	
}
