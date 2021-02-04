package ISA.Team54.users.service.implementations;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	@Override
	public Set<User> findBySurnameAndName(String surnameAndName) {
		Set<User> results = new HashSet<User>();
		String[] sn = surnameAndName.toUpperCase().split(" "); 
		String name;
		String surname;
		
		if(sn.length >1) {
			surname = sn[0];
			name = sn[1];
			results.addAll(patientRepository.findByNameAndSurnameIgnoreCaseIn(name,surname));
			results.addAll(patientRepository.findByNameAndSurnameIgnoreCaseIn(surname,name));
		}else if(!sn[0].equals("*")){
			name = sn[0];
			results.addAll(patientRepository.findByNameOrSurnameIgnoreCaseIn(name,name));
		}else {
			results.addAll(patientRepository.findAll());
		}
		
		return results;
	}

	@Override
	public List<Patient> findAll() {
		return patientRepository.findAll();
	}	

}
