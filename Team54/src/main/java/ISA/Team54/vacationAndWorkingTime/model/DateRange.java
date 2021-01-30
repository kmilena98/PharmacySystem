package ISA.Team54.vacationAndWorkingTime.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DateRange {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = false,nullable = true)
	private Date startDate;
	
	@Column(unique = false,nullable = true)
	private Date endDate;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private VacationRequest vacationRequest;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private WorkSchedule workSchedule;
	
	
	public DateRange() {
		super();
	}

	public DateRange(Long id,Date startDate, Date endDate) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
