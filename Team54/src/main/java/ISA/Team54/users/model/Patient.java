package ISA.Team54.users.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import ISA.Team54.drugAndRecipe.model.ERecipe;

@Entity
public class Patient extends User{
	@Column(unique = false,nullable = true)
	private int penaltyPoints;
	@Column(unique = false,nullable = true)
	private int loyaltyPoints;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ERecipe> eRecipes = new ArrayList<ERecipe>();
	
	public Patient() {
		super();
	}
		
	public Patient(int penaltyPoints, int loyaltyPoints) {
		super();
		this.penaltyPoints = penaltyPoints;
		this.loyaltyPoints = loyaltyPoints;
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
	
	
	
}
