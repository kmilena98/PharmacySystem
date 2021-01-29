package ISA.Team54.vacationAndWorkingTime.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ISA.Team54.users.model.Dermatologist;
import ISA.Team54.users.model.Pharmacist;
@Entity
public class WorkSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(mappedBy = "workSchedule", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private DateRange timePeriod;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Dermatologist dermatologist;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Pharmacist pharmacist;
	
	public WorkSchedule() {
		super();
	}

	public WorkSchedule(Long id,DateRange timePeriod) {
		super();
		this.id = id;
		this.timePeriod = timePeriod;
	}

	public DateRange getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(DateRange timePeriod) {
		this.timePeriod = timePeriod;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
