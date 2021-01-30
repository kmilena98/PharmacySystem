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
@Entity
public class DrugSpecification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToMany
	@JoinTable(name = "contraindicationInDrugSpecification",joinColumns= @JoinColumn(name = "drugSpecification_id", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "contraindication_id",referencedColumnName= "id"))
	private Set<Contraindication> contraindications = new HashSet<Contraindication>();
	
	@ManyToMany
	@JoinTable(name = "ingredientInDrugSpecification",joinColumns= @JoinColumn(name = "drugSpecification_id", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "ingredient_id",referencedColumnName= "id"))	
	private Set<Ingredient> ingredients = new HashSet<Ingredient>();
	
	@Column(unique = false,nullable = true)
	private int suggestedDose;
	
	@OneToMany(mappedBy="drugSpecification",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	public List<Drug> drugs = new ArrayList<Drug>();
	
	
	public DrugSpecification() {
		super();
	}

	
	public DrugSpecification(long id, int suggestedDose) {
		super();
		this.id = id;
		this.suggestedDose = suggestedDose;
	}


	public DrugSpecification(long id, Set<Contraindication> contraindications, Set<Ingredient> ingredients,
			int suggestedDose) {
		super();
		this.id = id;
		this.contraindications = contraindications;
		this.ingredients = ingredients;
		this.suggestedDose = suggestedDose;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Contraindication> getContraindications() {
		return contraindications;
	}

	public void setContraindications(Set<Contraindication> contraindications) {
		this.contraindications = contraindications;
	}

	public Set<Ingredient> getIngredinets() {
		return ingredients;
	}

	public void setIngredinets(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public int getSuggestedDose() {
		return suggestedDose;
	}

	public void setSuggestedDose(int suggestedDose) {
		this.suggestedDose = suggestedDose;
	}	
	
	
}
