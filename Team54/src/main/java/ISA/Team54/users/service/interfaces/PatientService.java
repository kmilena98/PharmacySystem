package ISA.Team54.users.service.interfaces;

import java.util.List;
import java.util.Set;

import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.User;

public interface PatientService {
	List<User> findByName(String name);
    List<User> findBySurname(String surname);
    Set<User> findBySurnameAndName(String surnameAndName);
    List<Patient> findAll();
    
}
