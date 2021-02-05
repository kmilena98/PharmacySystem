package ISA.Team54.Examination.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import ISA.Team54.Examination.enums.ExaminationStatus;
import ISA.Team54.Examination.enums.ExaminationType;
import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.Pharmacy;

@Entity
public class Examination {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	 @Column(unique = false,nullable = true)
	 private String diagnose;
	 
	 @Column(unique = false,nullable = false)
	 private int price; 
	 
	 //duration in minutes
	 @Column(unique = false,nullable = true)
	 private int therapyDuration;
	 
	 @Enumerated(EnumType.STRING)
	 private ExaminationType type;
	 
	 @Enumerated(EnumType.STRING)
	 private ExaminationStatus status;
	 
	 @Column(unique = false,nullable = false)
	 private int emplyeedId; 
	 
	 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)	
	 private Patient patient;
	 
	 @Embedded
	 private Term term;
	 
	 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	 private Pharmacy pharmacy;
	 
	 // da li ce trebati nova tabela ovde za kolicinu? --proveritiii
	 @ManyToMany
	 @JoinTable(name = "drugsInExamination",joinColumns= @JoinColumn(name = "examination_id", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "drug_id",referencedColumnName= "id"))
	 public List<Drug> drugs = new ArrayList<Drug>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getEmplyeedId() {
		return emplyeedId;
	}

	public void setEmplyeedId(int emplyeedId) {
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

	public int getTherapyDuration() {
		return therapyDuration;
	}

	public void setTherapyDuration(int therapyDuration) {
		this.therapyDuration = therapyDuration;
	}
	 
	 
}
