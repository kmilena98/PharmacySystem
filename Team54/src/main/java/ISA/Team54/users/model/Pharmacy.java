package ISA.Team54.users.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import ISA.Team54.Examination.model.Examination;

@Entity
public class Pharmacy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public Pharmacy() {
		super();
	}	
	 @ManyToMany
	 @JoinTable(name = "dermatologistsInPharmacy",joinColumns= @JoinColumn(name = "pharmacy_id", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "dermatologist_id",referencedColumnName= "id"))
	 public List<Dermatologist> dermatologists = new ArrayList<Dermatologist>();
	
	 @OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private List<Examination> examinations = new ArrayList<Examination>();
}
