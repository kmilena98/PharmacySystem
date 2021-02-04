package ISA.Team54.Examination.dto;

import java.time.LocalDateTime;

public class ExaminationDTO {
	int id;
	String patientName;
	String patientSurname;
	LocalDateTime examinationStart;
	
	
	public ExaminationDTO() {
		super();
	}


	public ExaminationDTO(int id,String patientName, String patientSurname, LocalDateTime examinationStart) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.patientSurname = patientSurname;
		this.examinationStart = examinationStart;
		
	}

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
	
	
	
}
