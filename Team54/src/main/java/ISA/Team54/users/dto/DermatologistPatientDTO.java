package ISA.Team54.users.dto;

import java.time.LocalDateTime;

import ISA.Team54.Examination.model.Term;

import ISA.Team54.Examination.model.Term;

import ISA.Team54.Examination.model.Term;

public class DermatologistPatientDTO extends PatientDTO {
	private LocalDateTime term;

	public DermatologistPatientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DermatologistPatientDTO(int id,String name, String surname,LocalDateTime term) {
		super(id, name, surname);
		this.term = term;
		// TODO Auto-generated constructor stub
	}

	public LocalDateTime getTerm() {
		return term;
	}

	public void setTerm(LocalDateTime term) {
		this.term = term;
	}
	
	

	
	
	
	
	
}
