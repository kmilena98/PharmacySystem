package ISA.Team54.Examination.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ISA.Team54.users.model.Patient;

@Entity
public class Examination {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	 private Patient patient;
}
