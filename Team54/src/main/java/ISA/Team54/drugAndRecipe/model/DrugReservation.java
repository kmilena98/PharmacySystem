package ISA.Team54.drugAndRecipe.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ISA.Team54.drugAndRecipe.model.enumerations.ReservationStatus;
import ISA.Team54.users.model.Patient;

@Entity
public class DrugReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = false,nullable = true)
	private Date reservationToDate;
	
	@Column(unique = false,nullable = true)
	private ReservationStatus status; 
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Patient patient;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private DrugInPharmacy reservedDrug;
}
