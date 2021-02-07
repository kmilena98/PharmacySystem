package ISA.Team54.users.service.implementations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.model.DrugAllergy;
import ISA.Team54.drugAndRecipe.service.interfaces.DrugService;
import ISA.Team54.users.dto.BasicPatientInfoDTO;
import ISA.Team54.users.exceptions.AllergyAlreadyAddedException;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.User;
import ISA.Team54.users.repository.PatientRepository;
import ISA.Team54.users.service.interfaces.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private DrugService drugService;
	
	public List<User> findByName(String name) throws AccessDeniedException {
		List<User> result = patientRepository.findByName(name);
		return result;		
	}	
	
	public List<User> findBySurname(String surname) throws AccessDeniedException {
		List<User> result = patientRepository.findBySurname(surname);
		return result;		
	}

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

	@Override
	public Optional<Patient> findById(Long id) {
		return patientRepository.findById(id);
	}	
	
	public Patient findById(long id) {
		Patient patient = patientRepository.findById(id);
		return patient;
	}
	
	public void updatePatient(BasicPatientInfoDTO dto) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Patient patient = patientRepository.findById(((Patient) authentication.getPrincipal()).getId());
		patient.setName(dto.getName());
		patient.setSurname(dto.getSurname());
		patient.setAddress(dto.getAddress());
		patient.setCity(dto.getCity());
		patient.setCountry(dto.getCountry());
		
		patientRepository.save(patient); 		
	}
	
	public List<Drug> getPatientAllergies(long id){
		Patient patient = patientRepository.findById(id);
		System.out.println(patient.getDrugAllergies());
		return patient.getDrugAllergies();
	}

	@Override
	public void deletePatientAllergy(long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Patient patient = patientRepository.findById(((Patient) authentication.getPrincipal()).getId());
		List<Drug> drugAllergies = patient.getDrugAllergies();
		Iterator<Drug> it = drugAllergies.iterator();
		while (it.hasNext()) {
			Drug allergy = it.next();
			if(allergy.getId() == id) {
				it.remove();
				break;				
			}
		}
		patientRepository.save(patient);
		
	}

	@Override
	public void addAllergy(long id) throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Patient patient = patientRepository.findById(((Patient) authentication.getPrincipal()).getId());
		
		Drug allergy = drugService.findById(id);		
		List<Drug> drugAllergies = patient.getDrugAllergies();
		
		for(int i = 0; i < drugAllergies.size(); i++) {
			if(drugAllergies.get(i).getId() == id)
				throw new AllergyAlreadyAddedException();
		}
		drugAllergies.add(allergy);
		patientRepository.save(patient);		
	}
}
