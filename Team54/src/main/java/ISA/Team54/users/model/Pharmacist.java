package ISA.Team54.users.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ISA.Team54.vacationAndWorkingTime.model.VacationRequest;
import ISA.Team54.vacationAndWorkingTime.model.WorkSchedule;

@Entity
public class Pharmacist extends User{
	@Column(unique = false,nullable = true)
	private double rating;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Pharmacy pharmacy;
	
	@OneToMany(mappedBy="pharmacist",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<WorkSchedule> workSchedules;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private VacationRequest vacationRequest;
	
	public Pharmacist() {
		super();
	}

	public Pharmacist(long id, Email email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, double rating, Pharmacy pharmacy, List<WorkSchedule> workSchedules) {
		super(id, email, password, name, surname, address, city, country, phoneNumber);
		this.rating = rating;
		this.pharmacy = pharmacy;
		this.workSchedules = workSchedules;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public List<WorkSchedule> getWorkSchedule() {
		return workSchedules;
	}

	public void setWorkSchedule(List<WorkSchedule> workSchedule) {
		this.workSchedules = workSchedule;
	}
	
	
	
}
