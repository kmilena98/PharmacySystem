package ISA.Team54.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Patient extends User{
	@Column(unique = false,nullable = true)
	private int penaltyPoints;
	@Column(unique = false,nullable = true)
	private int loyaltyPoints;
	
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
