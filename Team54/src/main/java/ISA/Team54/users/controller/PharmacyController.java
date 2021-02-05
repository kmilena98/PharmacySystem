package ISA.Team54.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team54.Examination.dto.DermatologistExaminationDTO;
import ISA.Team54.Examination.model.Examination;
import ISA.Team54.Examination.services.ExaminationService;
import ISA.Team54.users.dto.PharmacyDTO;
import ISA.Team54.users.model.Pharmacy;
import ISA.Team54.users.service.interfaces.PharmacyService;

@RestController
@RequestMapping(value = "/pharmacy", produces = MediaType.APPLICATION_JSON_VALUE)
public class PharmacyController {
	@Autowired
	private PharmacyService pharmacyService;
	
	@Autowired
	private ExaminationService examinationService;
	
	@PostMapping("/addPharmacy")
	@PreAuthorize("hasRole('SYSTEM_ADMIN')")
	public  ResponseEntity<Pharmacy>  addPharmacy(@RequestBody PharmacyDTO pharmacyDTO){
		return new ResponseEntity<>(this.pharmacyService.addPharmacy(pharmacyDTO), HttpStatus.CREATED);	
	}
	
	@GetMapping("/allPharmacies")
	@PreAuthorize("hasRole('SYSTEM_ADMIN')")
	public  List<Pharmacy> findAll(){
		return this.pharmacyService.findAll();
	}
	
	@GetMapping("{id}/dermatologist-examinations")
	@PreAuthorize("hasRole('ROLE_PATIENT')")
	public  ResponseEntity<List<DermatologistExaminationDTO>> getFreeDermatologistExaminationsForPharmacy(@PathVariable long id){
		return new ResponseEntity<List<DermatologistExaminationDTO>>(examinationService.getExaminationsForPharmacy(id), HttpStatus.OK);	

	}
}
