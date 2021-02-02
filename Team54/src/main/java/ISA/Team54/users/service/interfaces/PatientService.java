package ISA.Team54.users.service.interfaces;

import java.util.List;

import ISA.Team54.users.model.User;

public interface PatientService {
	List<User> findByName(String name);
    List<User> findBySurname(String surname);
}
