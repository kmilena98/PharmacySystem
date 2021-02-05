package ISA.Team54.drugAndRecipe.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import ISA.Team54.Examination.model.Examination;

@Entity
public class Drug {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = false,nullable = false)
	private String name;
	@Column(unique = false,nullable = false)
	private String code;
	@Column(unique = false,nullable = true)
	private int loyalityPoints;
	
	@ManyToMany(mappedBy="drugs")
	private Set<Examination> examinations;
	
	@ManyToMany(mappedBy="drugs")
	private Set<ERecipe> erecipes;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private DrugSpecification drugSpecification;
	
	public Drug() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getLoyalityPoints() {
		return loyalityPoints;
	}

	public void setLoyalityPoints(int loyalityPoints) {
		this.loyalityPoints = loyalityPoints;
	}

	public Set<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(Set<Examination> examinations) {
		this.examinations = examinations;
	}

	public Set<ERecipe> getErecipes() {
		return erecipes;
	}

	public void setErecipes(Set<ERecipe> erecipes) {
		this.erecipes = erecipes;
	}

	public DrugSpecification getDrugSpecification() {
		return drugSpecification;
	}

	public void setDrugSpecification(DrugSpecification drugSpecification) {
		this.drugSpecification = drugSpecification;
	}
}
