package ISA.Team54.users.mappers;

import ISA.Team54.users.dto.UserRequestDTO;
import ISA.Team54.users.model.Dermatologist;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.PharmacyAdministrator;
import ISA.Team54.users.model.Supplier;
import ISA.Team54.users.model.SystemAdministrator;
import ISA.Team54.users.model.User;

public class UserMapper {
	
	public static void UserRequestDTOToUser(UserRequestDTO userRequest,User user) {
		
		user.setEmail(userRequest.getEmail());
		user.setName(userRequest.getFirstName());
		user.setSurname(userRequest.getLastName());
		user.setAddress(userRequest.getAddress());
		user.setCity(userRequest.getCity());
		user.setCountry(userRequest.getCountry());
		user.setPhoneNumber(userRequest.getPhoneNumber());
								
	}
}
