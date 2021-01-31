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
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private WorkSchedule workSchedule;
	
	@OneToMany(mappedBy="pharmacist",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<VacationRequest> vacationRequest;
	
	public Pharmacist() {
		super();
	}

	public Pharmacist(long id, Email email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, double rating, Pharmacy pharmacy,WorkSchedule workSchedules) {
		super(id, email, password, name, surname, address, city, country, phoneNumber);
		this.rating = rating;
		this.pharmacy = pharmacy;
		this.workSchedule = workSchedules;
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

	public WorkSchedule getWorkSchedule() {
		return workSchedule;
	}

	public void setWorkSchedule(WorkSchedule workSchedule) {
		this.workSchedule = workSchedule;
	}
	
}
