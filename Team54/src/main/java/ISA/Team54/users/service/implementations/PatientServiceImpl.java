package ISA.Team54.users.service.implementations;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.User;
import ISA.Team54.users.repository.PatientRepository;
import ISA.Team54.users.service.interfaces.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	public List<User> findByName(String name) throws AccessDeniedException {
		List<User> result = patientRepository.findByName(name);
		return result;		
	}	
	
	public List<User> findBySurname(String surname) throws AccessDeniedException {
		List<User> result = patientRepository.findBySurname(surname);
		return result;		
	}	
	
	public Patient findById(long id) {
		Patient patient = patientRepository.findById(id);
		return patient;
	}
}
