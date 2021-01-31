package ISA.Team54.vacationAndWorkingTime.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ISA.Team54.sharedModel.DateRange;
import ISA.Team54.users.model.Dermatologist;
@Entity
public class DermatologistWorkSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Embedded
	private DateRange timePeriod;
	
	@OneToOne()
	private Dermatologist dermatologist;
	
	public DermatologistWorkSchedule() {
		super();
	}

	public DermatologistWorkSchedule(Long id,DateRange timePeriod) {
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
