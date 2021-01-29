package ISA.Team54.vacationAndWorkingTime.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ISA.Team54.users.model.Dermatologist;
import ISA.Team54.users.model.Pharmacist;
import ISA.Team54.vacationAndWorkingTime.enums.VacationRequestStatus;
@Entity
public class VacationRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(mappedBy = "vacationRequest", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private DateRange timePeriod;
	
	@Column(unique = false,nullable = true)
	private VacationRequestStatus status;
	
	@OneToOne(mappedBy = "vacationRequest", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Dermatologist dermatologist;
	
	@OneToOne(mappedBy = "vacationRequest", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Pharmacist pharmacist;

	public VacationRequest() {
		super();
	}

	public VacationRequest(Long id, DateRange timePeriod, VacationRequestStatus status, Dermatologist dermatologist,
			Pharmacist pharmacist) {
		super();
		this.id = id;
		this.timePeriod = timePeriod;
		this.status = status;
		this.dermatologist = dermatologist;
		this.pharmacist = pharmacist;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DateRange getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(DateRange timePeriod) {
		this.timePeriod = timePeriod;
	}
	
	public VacationRequestStatus getStatus() {
		return status;
	}

	public void setStatus(VacationRequestStatus status) {
		this.status = status;
	}
	
	public Dermatologist getDermatologist() {
		return dermatologist;
	}

	public void setDermatologist(Dermatologist dermatologist) {
		this.dermatologist = dermatologist;
	}

	public Pharmacist getPharmacist() {
		return pharmacist;
	}

	public void setPharmacist(Pharmacist pharmacist) {
		this.pharmacist = pharmacist;
	}

}
