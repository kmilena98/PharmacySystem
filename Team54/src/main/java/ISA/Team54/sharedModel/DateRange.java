package ISA.Team54.sharedModel;

import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class DateRange {
	private Date startDate;
	private Date endDate;
	
	public DateRange(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}	
}
