package ISA.Team54.drugAndRecipe.model;

import java.time.LocalDateTime;
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

import ISA.Team54.users.model.Patient;

@Entity
public class ERecipe {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	 @Column(unique = false,nullable = true)
	 private LocalDateTime dateOfIssue;
	 
	 @ManyToMany
	 @JoinTable(name = "drugsInERecipe",joinColumns= @JoinColumn(name = "erecipe_id", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "drug_id",referencedColumnName= "id"))
	 public List<Drug> drugs = new ArrayList<Drug>();
	 
	 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 private Patient patient;
	 
		/*
		 * @ManyToMany
		 * 
		 * @JoinTable(name = "pharmacyDrugsInERecipe",joinColumns= @JoinColumn(name =
		 * "erecipe_id", referencedColumnName = "id"),inverseJoinColumns
		 * = @JoinColumn(name = "drugInPharmacy_id",referencedColumnName=
		 * "drugInPharmacyId")) public List<DrugInPharmacy> drugsInPharmacy = new
		 * ArrayList<DrugInPharmacy>();
		 */

}
