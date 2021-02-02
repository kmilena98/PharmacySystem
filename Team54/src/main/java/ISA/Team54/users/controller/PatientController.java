package ISA.Team54.users.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team54.users.dto.PatientDTO;
import ISA.Team54.users.mapper.PatientMapper;
import ISA.Team54.users.model.User;
import ISA.Team54.users.service.interfaces.PatientService;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@GetMapping("patientByName/{name}")
	@PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
	public List<PatientDTO> loadByName(@PathVariable String name){
		List<PatientDTO> patientsDTO = new ArrayList<PatientDTO>();
		for(User user : this.patientService.findByName(name)) 
			patientsDTO.add(new PatientMapper().UserToPatientDTO(user));
		return patientsDTO;
	}
	
	@GetMapping("patientBySurnameAndName/{surnameAndName}")
	//@PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
	public List<PatientDTO> loadBySurnameAndName(@PathVariable String surnameAndName){
		List<PatientDTO> patientsDTO = new ArrayList<PatientDTO>();
		for(User user : this.patientService.findBySurnameAndName(surnameAndName)) 
			patientsDTO.add(new PatientMapper().UserToPatientDTO(user));
		return patientsDTO;
	}
	
	@GetMapping("/patientBySurname/{surname}")
	@PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
	public List<PatientDTO> loadBySurname(@PathVariable String surname){
		List<PatientDTO> patientsDTO = new ArrayList<PatientDTO>();
		for(User user : this.patientService.findBySurname(surname)) 
			patientsDTO.add(new PatientMapper().UserToPatientDTO(user));
		return patientsDTO;
	}
	
	@GetMapping("/allPatients/")
	//@PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
	public List<PatientDTO> loadPatients(){
		List<PatientDTO> patientsDTO = new ArrayList<PatientDTO>();
		for(User user : this.patientService.findAll()) 
			patientsDTO.add(new PatientMapper().UserToPatientDTO(user));
		return patientsDTO;
	}
}
