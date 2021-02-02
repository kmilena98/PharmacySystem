package ISA.Team54.users.service.interfaces;

import ISA.Team54.users.dto.UserRequestDTO;
import ISA.Team54.users.model.Dermatologist;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.PharmacyAdministrator;
import ISA.Team54.users.model.Supplier;
import ISA.Team54.users.model.SystemAdministrator;

public interface PharmacyService {
	Patient addPatient(UserRequestDTO userRequest);
	PharmacyAdministrator addPharmacyAdministrator(UserRequestDTO userRequest);
	SystemAdministrator addSystemAdministrator(UserRequestDTO userRequest);
	Dermatologist addDermatologist(UserRequestDTO userRequest);
	Supplier addSupplier(UserRequestDTO userRequest);
	

}
