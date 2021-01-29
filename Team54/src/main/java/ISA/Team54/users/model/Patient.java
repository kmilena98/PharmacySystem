package ISA.Team54.users.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Patient extends User{
	
	@Column(unique = false,nullable = true)
	private int penaltyPoints;
	
	@Column(unique = false,nullable = true)
	private int loyaltyPoints;
	
	@OneToMany(mappedBy="patient",cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	private List<DrugAllergy> drugAllergys;
	
	@OneToMany(mappedBy="patient",cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	private List<Complaint> complaints;
	
	@OneToMany(mappedBy="patient",cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	private List<DrugReservation> drugReservations;
	
	@OneToMany(mappedBy="patient",cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	private List<ERecipe> eRecipes;
	
	@OneToMany(mappedBy="patient",cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	private List<Pharmacy> pharmacys;
	
	@OneToMany(mappedBy="patient",cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	private List<Examiantion> examiantions;
	
			
	public Patient() {
		super();
	}
		
	public Patient(long id, Email email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, int penaltyPoints, int loyaltyPoints, List<DrugAllergy> drugAllergys,
			List<Complaint> complaints, List<DrugReservation> drugReservations, List<ERecipe> eRecipes,
			List<Pharmacy> pharmacys, List<Examiantion> examiantions) {
		super(id, email, password, name, surname, address, city, country, phoneNumber);
		this.penaltyPoints = penaltyPoints;
		this.loyaltyPoints = loyaltyPoints;
		this.drugAllergys = drugAllergys;
		this.complaints = complaints;
		this.drugReservations = drugReservations;
		this.eRecipes = eRecipes;
		this.pharmacys = pharmacys;
		this.examiantions = examiantions;
	}

	public int getPenaltyPoints() {
		return penaltyPoints;
	}


	public void setPenaltyPoints(int penaltyPoints) {
		this.penaltyPoints = penaltyPoints;
	}


	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}


	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}


	public List<DrugAllergy> getDrugAllergys() {
		return drugAllergys;
	}


	public void setDrugAllergys(List<DrugAllergy> drugAllergys) {
		this.drugAllergys = drugAllergys;
	}


	public List<Complaint> getComplaints() {
		return complaints;
	}


	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}


	public List<DrugReservation> getDrugReservations() {
		return drugReservations;
	}


	public void setDrugReservations(List<DrugReservation> drugReservations) {
		this.drugReservations = drugReservations;
	}


	public List<ERecipe> geteRecipes() {
		return eRecipes;
	}


	public void seteRecipes(List<ERecipe> eRecipes) {
		this.eRecipes = eRecipes;
	}


	public List<Pharmacy> getPharmacys() {
		return pharmacys;
	}


	public void setPharmacys(List<Pharmacy> pharmacys) {
		this.pharmacys = pharmacys;
	}


	public List<Examiantion> getExamiantions() {
		return examiantions;
	}


	public void setExamiantions(List<Examiantion> examiantions) {
		this.examiantions = examiantions;
	}

	
	
}
