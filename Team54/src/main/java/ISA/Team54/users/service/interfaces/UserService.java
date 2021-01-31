package ISA.Team54.users.service.interfaces;

import java.util.List;

import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.User;
import ISA.Team54.users.model.UserRequestDTO;

public interface UserService {
	Patient findById(Long id);
	Patient findByUsername(String username);
    List<Patient> findAll ();
	//User save(UserRequestDTO userRequest);
}
