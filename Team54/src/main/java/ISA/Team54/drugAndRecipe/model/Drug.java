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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private DrugSpecification drugSpecification;
	
	@ManyToMany
	@JoinTable(name="substituteDrugs",
	 joinColumns=@JoinColumn(name="mainDrugId"),
	 inverseJoinColumns=@JoinColumn(name="substituteDrugId")
	)
	private List<Drug> mainDrugs;

	@ManyToMany
	@JoinTable(name="substituteDrugs",
	 joinColumns=@JoinColumn(name="substituteDrugId"),
	 inverseJoinColumns=@JoinColumn(name="mainDrugId")
	)
	private List<Drug> substituteDrugs;
	
	public Drug() {
		super();
	}

	public Drug(long id, String name, String code, int loyalityPoints) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.loyalityPoints = loyalityPoints;
	}
	public int getId() {
		return (int) id;
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

	public List<Drug> getMainDrugs() {
		return mainDrugs;
	}

	public void setMainDrugs(List<Drug> mainDrugs) {
		this.mainDrugs = mainDrugs;
	}

	public List<Drug> getSubstituteDrugs() {
		return substituteDrugs;
	}

	public void setSubstituteDrugs(List<Drug> substituteDrugs) {
		this.substituteDrugs = substituteDrugs;
	}

	
	
}
