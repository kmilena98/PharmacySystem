package ISA.Team54.Examination.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import ISA.Team54.Examination.model.enums.ExaminationStatus;
import ISA.Team54.Examination.model.enums.ExaminationType;
import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.Pharmacy;

@Entity
public class Examination {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = false, nullable = true)
	private String diagnose;

	@Column(unique = false, nullable = false)
	private int price;

	@Column(unique = false, nullable = true)
	private Integer therapyDuration;

	@Enumerated(EnumType.STRING)
	private ExaminationType type;

	@Enumerated(EnumType.STRING)
	private ExaminationStatus status;

	@Column(unique = false, nullable = false)
	private long emplyeedId;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Patient patient;

	@Embedded
	private Term term;

	@JsonBackReference	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Pharmacy pharmacy;

	// da li ce trebati nova tabela ovde za kolicinu? --proveritiii
	@ManyToMany
	@JoinTable(name = "drugsInExamination", joinColumns = @JoinColumn(name = "examination_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "drug_id", referencedColumnName = "id"))
	public List<Drug> drugs;
	

	public Examination() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {      
		this.id = id;  
	}

	public String getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTherapyDuration() {
		return therapyDuration;
	}

	public void setTherapyDuration(int therapyDuration) {
		this.therapyDuration = therapyDuration;
	}

	public ExaminationType getType() {
		return type;
	}

	public void setType(ExaminationType type) {
		this.type = type;
	}

	public ExaminationStatus getStatus() {
		return status;
	}

	public void setStatus(ExaminationStatus status) {
		this.status = status;
	}

	public long getEmplyeedId() {
		return emplyeedId;
	}

	public void setEmplyeedId(long emplyeedId) {
		this.emplyeedId = emplyeedId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public List<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}

}
