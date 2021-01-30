package ISA.Team54.loyalty.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoyaltyCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private float discount;
	
	@Embedded
	private LoyaltyCategoryIntertval interval;
	
	public LoyaltyCategory(String name, float discount, int upperInterval, int lowerInterval) {
		super();
		this.name = name;
		this.discount = discount;
		this.interval = new LoyaltyCategoryIntertval(upperInterval, lowerInterval);
	}		
}
