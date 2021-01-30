package ISA.Team54.drugAndRecipe.model;

import java.util.ArrayList;
import java.util.List;

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

@Entity
public class Drug {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = false,nullable = true)
	private String name;
	@Column(unique = false,nullable = true)
	private String code;
	@Column(unique = false,nullable = true)
	private int loyalityPoints;
	
	/*
	 * @ManyToMany(mappedBy="drugsInPharmacy") public List<ERecipe>
	 * eRecipesInPharmacy = new ArrayList<ERecipe>();
	 */
	 
	@ManyToMany(mappedBy="drugs")
	private List<ERecipe> erecipes = new ArrayList<ERecipe>();
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private DrugSpecification drugSpecification;
	
	 @ManyToMany
	 @JoinTable(name = "allergiesInDrug",joinColumns= @JoinColumn(name = "drug_id", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "alergy_id",referencedColumnName= "id"))
	 public List<Drug> allergies = new ArrayList<Drug>();
	 
	// drugiInStorage
	/*
	 * @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY) private
	 * List<DrugInPharmacy> drugsInPharmacy = new ArrayList<DrugInPharmacy>();
	 */
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
	public Long getId() {
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
	public DrugSpecification getDrugSpecification() {
		return drugSpecification;
	}
	public void setDrugSpecification(DrugSpecification drugSpecification) {
		this.drugSpecification = drugSpecification;
	}
	
	
	
}
