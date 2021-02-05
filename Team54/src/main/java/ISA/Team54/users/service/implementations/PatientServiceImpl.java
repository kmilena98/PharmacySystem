package ISA.Team54.users.service.implementations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.model.DrugAllergy;
import ISA.Team54.drugAndRecipe.service.IDrugService;
import ISA.Team54.users.dto.BasicPatientInfoDTO;
import ISA.Team54.users.dto.UserInfoDTO;
import ISA.Team54.users.mappers.UserInfoMapper;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.User;
import ISA.Team54.users.repository.PatientRepository;
import ISA.Team54.users.service.interfaces.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private IDrugService drugService;
	
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
	
	public Patient findById(long id) {
		Patient patient = patientRepository.findById(id);
		return patient;
	}
	@Override
	public void updatePatient(UserInfoDTO dto) {
		Patient patient = patientRepository.findById(dto.getId());
		UserInfoMapper.UserInfoDTOTOUser(dto, patient);
		patientRepository.save(patient); 		
	} 
		
	@Override
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
	public void addAllergy(long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Patient patient = patientRepository.findById(((Patient) authentication.getPrincipal()).getId());
		
		Drug allergy = drugService.findById(id);		
		List<Drug> drugAllergies = patient.getDrugAllergies();
		drugAllergies.add(allergy);
		patientRepository.save(patient);		
	}
}
