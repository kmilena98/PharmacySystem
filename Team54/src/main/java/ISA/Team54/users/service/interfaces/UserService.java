package ISA.Team54.users.service.interfaces;

import java.util.List;

import ISA.Team54.users.dto.UserRequestDTO;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.User;

public interface UserService {
	User findById(Long id);
	User findByUsername(String username);
    List<User> findAll ();
	//User save(UserRequestDTO userRequest);
}
