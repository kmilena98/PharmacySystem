package ISA.Team54.drugAndRecipe.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Ingredient {
	
	@Id
	@SequenceGenerator(name = "IngredientSG", sequenceName = "IngredientSeq",initialValue = 10,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IngredientSG")
	private long id;
	
	@Column(unique = false,nullable = true)
	private String ingredient;
	
	@JsonBackReference(value="ingredient_clinci_movement")
	@ManyToMany(mappedBy = "ingredients")
	private Set<DrugSpecification> drugSpecifications = new HashSet<DrugSpecification>();
	
	public Ingredient() {
		super();
	}

	
	public Ingredient(String ingredient) {
		super();
		this.ingredient = ingredient;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public Set<DrugSpecification> getDrugSpecifications() {
		return drugSpecifications;
	}

	public void setDrugSpecifications(Set<DrugSpecification> drugSpecifications) {
		this.drugSpecifications = drugSpecifications;
	}	
	
}
