package ISA.Team54.drugAndRecipe.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ISA.Team54.users.model.Patient;

@Entity
@Table(name="drug_allergies")
public class DrugAllergy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	private Drug drug;
	
	@OneToOne
	private Patient patient;

	public DrugAllergy() {
		super();
	}

	public DrugAllergy(long id, Drug drugs, Patient patient) {
		super();
		this.id = id;
		this.drug = drugs;
		this.patient = patient;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Drug getDrugs() {
		return drug;
	}

	public void setDrugs(Drug drug) {
		this.drug = drug;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
}
