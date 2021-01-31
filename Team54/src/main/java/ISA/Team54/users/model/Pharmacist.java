package ISA.Team54.users.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ISA.Team54.sharedModel.DateRange;
import ISA.Team54.vacationAndWorkingTime.model.DermatologistWorkSchedule;
import ISA.Team54.vacationAndWorkingTime.model.VacationRequest;

@Entity
public class Pharmacist extends User{
	@Column(unique = false,nullable = true)
	private double rating;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Pharmacy pharmacy;
	
	@Embedded
	private DateRange workSchedule;
	
	@OneToMany(mappedBy="pharmacist",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<VacationRequest> vacationRequest;
	
	public Pharmacist() {
		super();
	}

	public Pharmacist(long id, Email email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, double rating, Pharmacy pharmacy,DateRange workSchedules) {
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

	public DateRange getWorkSchedule() {
		return workSchedule;
	}

	public void setWorkSchedule(DateRange workSchedule) {
		this.workSchedule = workSchedule;
	}
	
}
