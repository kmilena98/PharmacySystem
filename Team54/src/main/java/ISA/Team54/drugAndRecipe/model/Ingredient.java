package ISA.Team54.drugAndRecipe.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = false,nullable = true)
	private String ingredient;
	
	@ManyToMany(mappedBy = "ingredients")
	private Set<DrugSpecification> drugSpecifications = new HashSet<DrugSpecification>();
	
	public Ingredient() {
		super();
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
