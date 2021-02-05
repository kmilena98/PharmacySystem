package ISA.Team54.drugAndRecipe.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
public class DrugSpecification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String contraindications;
	
	@ManyToMany
	@JoinTable(name = "ingredientInDrugSpecification",joinColumns= @JoinColumn(name = "drugSpecification_id", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "ingredient_id",referencedColumnName= "id"))	
	private List<Ingredient> ingredients;
	
	@Column(unique = false,nullable = false)
	private String suggestedDose;	
	
	@OneToOne(fetch = FetchType.LAZY)
	private Drug drug;
	
	public DrugSpecification() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContraindications() {
		return contraindications;
	}

	public void setContraindications(String contraindications) {
		this.contraindications = contraindications;
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
