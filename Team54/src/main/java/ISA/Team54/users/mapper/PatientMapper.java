package ISA.Team54.users.mapper;

import ISA.Team54.users.dto.PatientDTO;
import ISA.Team54.users.model.User;

public class PatientMapper {

	public  PatientDTO UserToPatientDTO(User user) {
		return new PatientDTO(user.getName(), user.getSurname());
	}
}
