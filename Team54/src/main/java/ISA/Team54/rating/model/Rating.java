package ISA.Team54.rating.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ISA.Team54.rating.enums.RatingObject;
import ISA.Team54.users.model.Dermatologist;
import ISA.Team54.users.model.Pharmacist;
import ISA.Team54.users.model.Pharmacy;
@Entity
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonBackReference
	@ManyToOne
	@Null
	private Dermatologist dermatologist;
	
	@JsonBackReference
	@ManyToOne
	@Null
	private Pharmacist pharmacist;
	
	@JsonBackReference
	@ManyToOne
	@Null
	private Pharmacy pharmacy;
	
	@Column(unique = false,nullable = false)
	private double rating;
	
	public Rating() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Dermatologist getDermatoligist() {
		return dermatologist;
	}

	public void setDermatoligist(Dermatologist dermatoligist) {
		this.dermatologist = dermatoligist;
	}

	public Pharmacist getPharmacist() {
		return pharmacist;
	}

	
	public void setPharmacist(Pharmacist pharmacist) {
		this.pharmacist = pharmacist;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
}
