package ISA.Team54.users.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ISA.Team54.drugOrdering.model.DrugsOrder;

@Entity
public class PharmacyAdministrator extends User{

	@OneToMany(mappedBy = "administrator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DrugsOrder> drugOrders;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Pharmacy pharmacy;
	
	public PharmacyAdministrator() {
		
	}

	public PharmacyAdministrator(long id, Email email, String password, String name, String surname, String address,
			String city, String country, String phoneNumber, List<DrugsOrder> drugOrder) {
		super(id, email, password, name, surname, address, city, country, phoneNumber);
		this.drugOrders = drugOrder;
	}
	
	
	
	

}
