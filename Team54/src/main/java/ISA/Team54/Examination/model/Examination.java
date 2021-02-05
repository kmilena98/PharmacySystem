package ISA.Team54.Examination.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

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
	 
	 @Enumerated(EnumType.STRING)
	 private ExaminationType type;
	 
	 @Enumerated(EnumType.STRING)
	 private ExaminationStatus status;
	 
	 @Column(unique = false,nullable = false)
	 private int emplyeedId; 
	 
	 @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	 private Patient patient;
	 
	 @Embedded
	 private Term term;
	 
	 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	 private Pharmacy pharmacy;
	 
	 // da li ce trebati nova tabela ovde za kolicinu? --proveritiii
	 @ManyToMany
	 @JoinTable(name = "drugsInExamination",joinColumns= @JoinColumn(name = "examination_id", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "drug_id",referencedColumnName= "id"))
	 public List<Drug> drugs = new ArrayList<Drug>();
}
