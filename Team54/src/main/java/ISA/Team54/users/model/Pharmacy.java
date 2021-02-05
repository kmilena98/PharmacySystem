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
import javax.persistence.SequenceGenerator;

import ISA.Team54.Examination.model.Examination;
import ISA.Team54.drugAndRecipe.model.DrugInPharmacy;
import ISA.Team54.promotion.model.Promotion;

@Entity
public class Pharmacy {
	@Id
	@SequenceGenerator(name = "mySeqGen2", sequenceName = "mySeq2",initialValue = 3,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGen2")
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
	
	// zbog ovoga se dva puta pojavi pharmacy_id u drug in pharmacy, proveriti da li nam treba
	/*
	 * @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY) public
	 * List<DrugInPharmacy> drugs = new ArrayList<DrugInPharmacy>();
	 */

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

	public Pharmacy(long id, String name, String address, String description,
			List<PharmacyAdministrator> pharmacyAdministrators, List<Promotion> promotion,
			List<Patient> subscribedPatients, List<Dermatologist> dermatologists, List<Pharmacist> pharmacists,
			List<Examination> examinations) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.pharmacyAdministrators = pharmacyAdministrators;

		this.promotion = promotion;
		this.subscribedPatients = subscribedPatients;
		this.dermatologists = dermatologists;
		this.pharmacists = pharmacists;
		this.examinations = examinations;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PharmacyAdministrator> getPharmacyAdministrators() {
		return pharmacyAdministrators;
	}

	public void setPharmacyAdministrators(List<PharmacyAdministrator> pharmacyAdministrators) {
		this.pharmacyAdministrators = pharmacyAdministrators;
	}

	public List<Promotion> getPromotion() {
		return promotion;
	}

	public void setPromotion(List<Promotion> promotion) {
		this.promotion = promotion;
	}

	public List<Patient> getSubscribedPatients() {
		return subscribedPatients;
	}

	public void setSubscribedPatients(List<Patient> subscribedPatients) {
		this.subscribedPatients = subscribedPatients;
	}

	public List<Dermatologist> getDermatologists() {
		return dermatologists;
	}

	public void setDermatologists(List<Dermatologist> dermatologists) {
		this.dermatologists = dermatologists;
	}

	public List<Pharmacist> getPharmacists() {
		return pharmacists;
	}

	public void setPharmacists(List<Pharmacist> pharmacists) {
		this.pharmacists = pharmacists;
	}

	public List<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}
	
	
}
