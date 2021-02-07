package ISA.Team54.Examination.dto;

import java.util.Date;

import ISA.Team54.Examination.enums.ExaminationType;

public class ExaminationSearchDTO {
	private Date from;
	private Date to;
	private ExaminationType type;
	
	public ExaminationSearchDTO() {
		super();
	}
	
	public ExaminationSearchDTO(Date from, Date to, ExaminationType type) {
		super();
		this.from = from;
		this.to = to;
		this.type = type;
	}
	
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	public ExaminationType getType() {
		return type;
	}
	public void setType(ExaminationType type) {
		this.type = type;
	}

}
