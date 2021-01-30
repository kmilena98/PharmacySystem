package ISA.Team54.users.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ISA.Team54.vacationAndWorkingTime.model.VacationRequest;
import ISA.Team54.vacationAndWorkingTime.model.WorkSchedule;

@Entity
public class Dermatologist extends User{
	@Column(unique = false,nullable = true)
	private double price;
	
	@Column(unique = false,nullable = true)
	private double rating;
	
	@OneToMany(mappedBy="dermatologist",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<WorkSchedule> workSchedules;
	
	@ManyToMany(mappedBy="dermatologists")
	private List<Pharmacy> pharmacys = new ArrayList<Pharmacy>();
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private VacationRequest vacationRequest;
	
	
	public Dermatologist() {
		super();
	}

	public Dermatologist(long id, Email email, String password, String name, String surname, String address,
			String city, String country, String phoneNumber, double price, double rating,
			List<WorkSchedule> workSchedule, List<Pharmacy> pharmacy) {
		super(id, email, password, name, surname, address, city, country, phoneNumber);
		this.price = price;
		this.rating = rating;
		this.workSchedules = workSchedule;
		this.pharmacys = pharmacy;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<WorkSchedule> getWorkSchedule() {
		return workSchedules;
	}

	public void setWorkSchedule(List<WorkSchedule> workSchedule) {
		this.workSchedules = workSchedule;
	}

	public List<Pharmacy> getPharmacy() {
		return pharmacys;
	}

	public void setPharmacy(List<Pharmacy> pharmacy) {
		this.pharmacys = pharmacy;
	}
	
	
	
}
