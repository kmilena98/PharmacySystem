package ISA.Team54.users.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import ISA.Team54.Examination.model.Examination;
import ISA.Team54.drugAndRecipe.model.DrugAllergy;
import ISA.Team54.drugAndRecipe.model.DrugReservation;
import ISA.Team54.drugAndRecipe.model.ERecipe;

@Entity
public class Patient extends User{
	
	@Column(unique = false,nullable = true)
	private int penaltyPoints;
	
	@Column(unique = false,nullable = true)
	private int loyaltyPoints;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ERecipe> eRecipes = new ArrayList<ERecipe>();
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<DrugAllergy> drugAllergies = new ArrayList<DrugAllergy>();
	
	@OneToMany(mappedBy="patient",cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	private List<Complaint> complaints;
	
	@OneToMany(mappedBy="patient",cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	private List<DrugReservation> drugReservations;	
	
	@ManyToMany(mappedBy= "subscribedPatients")
	private List<Pharmacy> prescriptionsPharmacies;
	
	@OneToMany(mappedBy="patient",cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	private List<Examination> examinations;
	
	public Patient() {
		super();
	}
		
	

	public Patient(int penaltyPoints, int loyaltyPoints, List<ERecipe> eRecipes, List<DrugAllergy> drugAllergies,
			List<Complaint> complaints, List<DrugReservation> drugReservations, List<Pharmacy> pharmacys,
			List<Examination> examinations) {
		super();
		this.penaltyPoints = penaltyPoints;
		this.loyaltyPoints = loyaltyPoints;
		this.eRecipes = eRecipes;
		this.drugAllergies = drugAllergies;
		this.complaints = complaints;
		this.drugReservations = drugReservations;
		//this.pharmacys = pharmacys;
		this.examinations = examinations;
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


	
	public List<DrugAllergy> getDrugAllergies() {
		return drugAllergies;
	}



	public void setDrugAllergies(List<DrugAllergy> drugAllergies) {
		this.drugAllergies = drugAllergies;
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


	/*
	 * public List<Pharmacy> getPharmacys() { return pharmacys; }
	 * 
	 * 
	 * public void setPharmacys(List<Pharmacy> pharmacys) { this.pharmacys =
	 * pharmacys; }
	 */


	public List<Examination> getExamiantions() {
		return examinations;
	}


	public void setExamiantions(List<Examination> examiantions) {
		this.examinations = examiantions;
	}
	
}
