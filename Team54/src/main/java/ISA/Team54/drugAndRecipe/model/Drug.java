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
	private List<Examination> examinations = new ArrayList<Examination>();
	
	@ManyToMany(mappedBy="drugs")
	private List<ERecipe> erecipes = new ArrayList<ERecipe>();
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private DrugSpecification drugSpecification;
	
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
