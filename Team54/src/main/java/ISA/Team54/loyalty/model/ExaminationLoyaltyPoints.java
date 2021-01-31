package ISA.Team54.loyalty.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import ISA.Team54.loyalty.enums.LoyaltyExaminationPoints;

@Entity
public class ExaminationLoyaltyPoints {
	
	@Id
	private LoyaltyExaminationPoints type;
	
	@Column(nullable = false)
	private int points;
	
	public ExaminationLoyaltyPoints(LoyaltyExaminationPoints type, int points) {
		this.type = type;
		this.points = points;
	}	
}
