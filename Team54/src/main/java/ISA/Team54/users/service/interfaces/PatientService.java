package ISA.Team54.users.service.interfaces;

import java.util.List;
import java.util.Set;

import ISA.Team54.users.dto.BasicPatientInfoDTO;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.User;

public interface PatientService {
	List<User> findByName(String name);
    List<User> findBySurname(String surname);
    Patient findById(long id);
    void updatePatient(BasicPatientInfoDTO patient);
    Set<User> findBySurnameAndName(String surnameAndName);
    List<Patient> findAll();
}
