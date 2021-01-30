package ISA.Team54.rating.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ISA.Team54.rating.enums.RatingObject;
@Entity
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = false,nullable = true)
	private Long objectId;
	
	@Column(unique = false,nullable = true)
	private double rating;
	
	@Column(unique = false,nullable = true)
	private RatingObject objectType;

	public Rating() {
		super();
	}

	public Rating(Long id, Long objectId, double rating, RatingObject objectType) {
		super();
		this.id = id;
		this.objectId = objectId;
		this.rating = rating;
		this.objectType = objectType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public RatingObject getObjectType() {
		return objectType;
	}

	public void setObjectType(RatingObject objectType) {
		this.objectType = objectType;
	}
	
	
	
}
