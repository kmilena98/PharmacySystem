package ISA.Team54.drugOrdering.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ISA.Team54.users.enums.OfferStatus;
import ISA.Team54.users.model.Suplier;
@Entity
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = false,nullable = true)
	private double totalPrice;
	
	@Column(unique = false,nullable = true)
	private Date deliveryDeadline;
	
	@Column(unique = false,nullable = true)
	private OfferStatus status;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Suplier suplier;

	public Offer() {
		super();
	}

	public Offer(long id, double totalPrice, Date deliveryDeadline, OfferStatus status, Suplier suplier) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
		this.deliveryDeadline = deliveryDeadline;
		this.status = status;
		this.suplier = suplier;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getDeliveryDeadline() {
		return deliveryDeadline;
	}

	public void setDeliveryDeadline(Date deliveryDeadline) {
		this.deliveryDeadline = deliveryDeadline;
	}

	public OfferStatus getStatus() {
		return status;
	}

	public void setStatus(OfferStatus status) {
		this.status = status;
	}

	public Suplier getSuplier() {
		return suplier;
	}

	public void setSuplier(Suplier suplier) {
		this.suplier = suplier;
	}
	
	
	
}
