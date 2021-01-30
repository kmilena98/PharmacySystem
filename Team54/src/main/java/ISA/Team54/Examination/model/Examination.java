package ISA.Team54.Examination.model;

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

import ISA.Team54.Examination.model.enums.ExaminationStatus;
import ISA.Team54.Examination.model.enums.ExaminationType;
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
	 
	 @Column(unique = false,nullable = false)
	 private ExaminationType type;
	 
	 @Column(unique = false,nullable = true)
	 private ExaminationStatus status;
	 
	 @Column(unique = false,nullable = true)
	 private int emplyeedId; 
	 
	 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	 private Patient patient;
	 
	 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	 private Term term;
	 
	 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	 private Pharmacy pharmacy;
	 
	 // da li ce trebati nova tabela ovde za kolicinu? --proveritiii
	 @ManyToMany
	 @JoinTable(name = "drugsInExamination",joinColumns= @JoinColumn(name = "examination_id", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "drug_id",referencedColumnName= "id"))
	 public List<Drug> drugs = new ArrayList<Drug>();
}
