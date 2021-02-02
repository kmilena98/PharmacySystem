package ISA.Team54.users.mappers;

import ISA.Team54.users.dto.UserRequestDTO;
import ISA.Team54.users.model.Dermatologist;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.PharmacyAdministrator;
import ISA.Team54.users.model.Supplier;
import ISA.Team54.users.model.SystemAdministrator;

public class UserMapper {
	
	public static Patient UserRequestDTOToPatient(UserRequestDTO userRequest) {
		Patient patient = new Patient();
		patient.setEmail(userRequest.getEmail());
		patient.setName(userRequest.getFirstName());
		patient.setSurname(userRequest.getLastName());
		patient.setAddress(userRequest.getAddress());
		patient.setCity(userRequest.getCity());
		patient.setCountry(userRequest.getCountry());
		patient.setPhoneNumber(userRequest.getPhoneNumber());
						
		return patient;
	}
	
	public static PharmacyAdministrator UserRequestDTOaToPharmacyAdministrator(UserRequestDTO userRequest) {
		PharmacyAdministrator pharmacyAdministrator = new PharmacyAdministrator();
		pharmacyAdministrator.setEmail(userRequest.getEmail());
		pharmacyAdministrator.setName(userRequest.getFirstName());
		pharmacyAdministrator.setSurname(userRequest.getLastName());
		pharmacyAdministrator.setAddress(userRequest.getAddress());
		pharmacyAdministrator.setCity(userRequest.getCity());
		pharmacyAdministrator.setCountry(userRequest.getCountry());
		pharmacyAdministrator.setPhoneNumber(userRequest.getPhoneNumber());
						
		return pharmacyAdministrator;
	} 
	
	public static SystemAdministrator UserRequestDTOaToSystemAdministrator(UserRequestDTO userRequest) {
		SystemAdministrator systemAdministrator = new SystemAdministrator();
		systemAdministrator.setEmail(userRequest.getEmail());
		systemAdministrator.setName(userRequest.getFirstName());
		systemAdministrator.setSurname(userRequest.getLastName());
		systemAdministrator.setAddress(userRequest.getAddress());
		systemAdministrator.setCity(userRequest.getCity());
		systemAdministrator.setCountry(userRequest.getCountry());
		systemAdministrator.setPhoneNumber(userRequest.getPhoneNumber());
						
		return systemAdministrator;
	} 
	
	public static Dermatologist UserRequestDTOaToDermatologist(UserRequestDTO userRequest) {
		Dermatologist dermatologist = new Dermatologist();
		dermatologist.setEmail(userRequest.getEmail());
		dermatologist.setName(userRequest.getFirstName());
		dermatologist.setSurname(userRequest.getLastName());
		dermatologist.setAddress(userRequest.getAddress());
		dermatologist.setCity(userRequest.getCity());
		dermatologist.setCountry(userRequest.getCountry());
		dermatologist.setPhoneNumber(userRequest.getPhoneNumber());
						
		return dermatologist;
	} 
	
	public static Supplier UserRequestDTOaToSupplier(UserRequestDTO userRequest) {
		Supplier supplier = new Supplier();
		supplier.setEmail(userRequest.getEmail());
		supplier.setName(userRequest.getFirstName());
		supplier.setSurname(userRequest.getLastName());
		supplier.setAddress(userRequest.getAddress());
		supplier.setCity(userRequest.getCity());
		supplier.setCountry(userRequest.getCountry());
		supplier.setPhoneNumber(userRequest.getPhoneNumber());
						
		return supplier;
	} 
}
