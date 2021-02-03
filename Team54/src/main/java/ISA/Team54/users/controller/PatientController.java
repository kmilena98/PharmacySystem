package ISA.Team54.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team54.users.dto.BasicPatientInfoDTO;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.User;
import ISA.Team54.users.service.interfaces.PatientService;

@RestController
@RequestMapping(value = "/patient", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@GetMapping("patientByName/{name}")
	@PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
	public List<User> loadByName(@PathVariable String name){
		return this.patientService.findByName(name);
	}
	
	@GetMapping("patientBySurname/{surname}")
	@PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
	public List<User> loadBySurname(@PathVariable String surname){
		return this.patientService.findBySurname(surname);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('PATIENT')")
	public Patient loadById(@PathVariable long id){
		return this.patientService.findById(id);
	}
	
	@PutMapping("")
	@PreAuthorize("hasRole('PATIENT')")
	public void updatePatient(@RequestBody BasicPatientInfoDTO patient){
		this.patientService.updatePatient(patient);
	}
	
	
}
