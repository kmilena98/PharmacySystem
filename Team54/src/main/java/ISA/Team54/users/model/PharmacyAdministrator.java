package ISA.Team54.users.model;

import javax.persistence.Entity;

@Entity
public class PharmacyAdministrator extends User{

	public PharmacyAdministrator() {
		
	}

	public PharmacyAdministrator(long id, Email email, String password, String name, String surname, String address,
			String city, String country, String phoneNumber) {
		super(id, email, password, name, surname, address, city, country, phoneNumber);
	}
	
	

}
