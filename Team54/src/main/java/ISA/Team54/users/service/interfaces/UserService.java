package ISA.Team54.users.service.interfaces;

import java.util.List;

import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.User;
import ISA.Team54.users.model.UserRequestDTO;

public interface UserService {
	User findById(Long id);
	User findByUsername(String username);
    List<User> findAll ();
	//User save(UserRequestDTO userRequest);
}
