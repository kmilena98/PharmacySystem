package ISA.Team54.Examination.dto;

import java.util.Date;

import ISA.Team54.Examination.model.Term;

public class DermatologistExaminationDTO {
	private long examinationId;
	private Date term;
	private String dermatologist;
	private double dermatologistRating;
	private double price;
	
	public DermatologistExaminationDTO(long examinationId, Term term, String dermatologist, double dermatologistRating,
			double price) {
		super();
		this.examinationId = examinationId;
		this.term = term.getStart();
		this.dermatologist = dermatologist;
		this.dermatologistRating = dermatologistRating;
		this.price = price;
	}

	public DermatologistExaminationDTO() {
		super();
	}

	public long getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(long examinationId) {
		this.examinationId = examinationId;
	}

	public Date getTerm() {
		return term;
	}

	public void setTerm(Date term) {
		this.term = term;
	}

	public String getDermatologist() {
		return dermatologist;
	}

	public void setDermatologist(String dermatologist) {
		this.dermatologist = dermatologist;
	}

	public double getDermatologistRating() {
		return dermatologistRating;
	}

	public void setDermatologistRating(double dermatologistRating) {
		this.dermatologistRating = dermatologistRating;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
