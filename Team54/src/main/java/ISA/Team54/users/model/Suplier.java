package ISA.Team54.users.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ISA.Team54.drugOrdering.model.Offer;

@Entity
public class Suplier extends User{
	
	@OneToMany(mappedBy="suplier",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Offer> offer;
	
	public Suplier() {
		super();
	}

	public Suplier(long id, Email email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, List<Offer> offer) {
		super(id, email, password, name, surname, address, city, country, phoneNumber);
		this.offer = offer;
	}

	public List<Offer> getOffer() {
		return offer;
	}

	public void setOffer(List<Offer> offer) {
		this.offer = offer;
	}

	
	
	
	
}
