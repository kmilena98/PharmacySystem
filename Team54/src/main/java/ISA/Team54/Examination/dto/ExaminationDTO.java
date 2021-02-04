package ISA.Team54.Examination.dto;

import java.time.LocalDateTime;

public class ExaminationDTO {
	int id;
	String dermatologistName;
	String dermatologistSurname;
	LocalDateTime examinationStart;
	
	
	public ExaminationDTO() {
		super();
	}


	public ExaminationDTO(int id,String dermatologistName, String dermatologistSurname, LocalDateTime examinationStart) {
		super();
		this.id = id;
		this.dermatologistName = dermatologistName;
		this.dermatologistSurname = dermatologistSurname;
		this.examinationStart = examinationStart;
		
	}

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDermatologistName() {
		return dermatologistName;
	}


	public void setDermatologistName(String dermatologistName) {
		this.dermatologistName = dermatologistName;
	}


	public String getDermatologistSurname() {
		return dermatologistSurname;
	}


	public void setDermatologistSurname(String dermatologistSurname) {
		this.dermatologistSurname = dermatologistSurname;
	}


	public LocalDateTime getExaminationStart() {
		return examinationStart;
	}


	public void setExaminationStart(LocalDateTime examinationStart) {
		this.examinationStart = examinationStart;
	}
	
	
	
}
