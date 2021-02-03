package ISA.Team54.Examination.dto;

import java.time.LocalDateTime;

public class ExaminationDTO {
	String patientName;
	String patientSurname;
	LocalDateTime examinationStart;
	int duration;
	
	
	public ExaminationDTO() {
		super();
	}


	public ExaminationDTO(String patientName, String patientSurname, LocalDateTime examinationStart, int duration) {
		super();
		this.patientName = patientName;
		this.patientSurname = patientSurname;
		this.examinationStart = examinationStart;
		this.duration = duration;
	}


	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public String getPatientSurname() {
		return patientSurname;
	}


	public void setPatientSurname(String patientSurname) {
		this.patientSurname = patientSurname;
	}


	public LocalDateTime getExaminationStart() {
		return examinationStart;
	}


	public void setExaminationStart(LocalDateTime examinationStart) {
		this.examinationStart = examinationStart;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
	
}
