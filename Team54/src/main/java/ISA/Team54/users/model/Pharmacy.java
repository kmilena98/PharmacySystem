package ISA.Team54.users.model;

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

import ISA.Team54.Examination.model.Examination;
import ISA.Team54.drugAndRecipe.model.DrugInPharmacy;
import ISA.Team54.promotion.model.Promotion;

@Entity
public class Pharmacy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = false, nullable = false)
	private String name;
	@Column(unique = false, nullable = false)
	private String address;
	@Column(unique = false, nullable = true)
	private String description;

	public Pharmacy() {
		super();
	}
	
	@OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<PharmacyAdministrator> pharmacyAdministrators;
			
	@OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<DrugInPharmacy> drugs = new ArrayList<DrugInPharmacy>();

	@OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Promotion> promotion = new ArrayList<Promotion>();

	@ManyToMany
	@JoinTable(name = "prescriptedPatientsToPharmacies", joinColumns = @JoinColumn(name = "pharmacy_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "dermatologist_id", referencedColumnName = "id"))
	public List<Patient> subscribedPatients = new ArrayList<Patient>();

	@ManyToMany
	@JoinTable(name = "dermatologistsInPharmacy", joinColumns = @JoinColumn(name = "pharmacy_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "dermatologist_id", referencedColumnName = "id"))
	public List<Dermatologist> dermatologists = new ArrayList<Dermatologist>();

	@OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Pharmacist> pharmacists = new ArrayList<Pharmacist>();

	@OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Examination> examinations = new ArrayList<Examination>();
}
