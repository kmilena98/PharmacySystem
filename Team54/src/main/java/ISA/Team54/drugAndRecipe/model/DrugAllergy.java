package ISA.Team54.drugAndRecipe.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import ISA.Team54.users.model.Patient;

@Entity
public class DrugAllergy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToMany(mappedBy="allergies")
	private List<Drug> drugs = new ArrayList<Drug>();
	
	@ManyToMany(mappedBy="drugAllergies")
	private List<Patient> alergicPatients = new ArrayList<Patient>();
	
}
