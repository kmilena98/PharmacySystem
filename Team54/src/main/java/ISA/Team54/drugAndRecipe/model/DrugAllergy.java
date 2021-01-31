package ISA.Team54.drugAndRecipe.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import ISA.Team54.users.model.Patient;

@Entity
public class DrugAllergy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne()
	private Drug drugs;
	
	@OneToOne()
	private Patient patient;

	public DrugAllergy() {
		super();
	}

	public DrugAllergy(long id, Drug drugs, Patient patient) {
		super();
		this.id = id;
		this.drugs = drugs;
		this.patient = patient;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Drug getDrugs() {
		return drugs;
	}

	public void setDrugs(Drug drugs) {
		this.drugs = drugs;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
}
