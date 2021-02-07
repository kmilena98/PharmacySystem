package ISA.Team54.Examination.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class ScheduleExaminaitonDTO {
	private long examinationId;
	private Date date;
	
	public ScheduleExaminaitonDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScheduleExaminaitonDTO(long examinationId, Date date) {
		super();
		this.examinationId = examinationId;
		this.date = date;
	}
	public long getExaminationId() {
		return examinationId;
	}
	public void setExaminationId(long examinationId) {
		this.examinationId = examinationId;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	/*
	 * public String getTime() { return time; }
	 * 
	 * public int getHours() { String hoursAndMinutes[] = this.time.split(":");
	 * return Integer.parseInt(hoursAndMinutes[0]); } public int getMinutes() {
	 * String hoursAndMinutes[] = this.time.split(":"); return
	 * Integer.parseInt(hoursAndMinutes[1]); } public void setTime(String time) {
	 * this.time = time; }
	 */
	
	
	
}
