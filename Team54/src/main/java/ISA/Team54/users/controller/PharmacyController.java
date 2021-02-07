package ISA.Team54.users.controller;

import java.util.ArrayList;
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
import ISA.Team54.Examination.dto.ExaminationSearchDTO;
import ISA.Team54.Examination.dto.ExaminationTypeDTO;
import ISA.Team54.Examination.enums.ExaminationType;
import ISA.Team54.Examination.model.Examination;
import ISA.Team54.Examination.service.interfaces.ExaminationService;
import ISA.Team54.users.dto.PharmacyDTO;
import ISA.Team54.users.dto.PharmacyExaminationDTO;
import ISA.Team54.users.mappers.PharmacyMapper;
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
	//@PreAuthorize("hasRole('SISTEM_ADMIN')")
	public  ResponseEntity<Pharmacy>  addPharmacy(@PathVariable PharmacyDTO pharmacyDTO){
		return new ResponseEntity<>(this.pharmacyService.addPharmacy(pharmacyDTO), HttpStatus.CREATED);	
	}
	
	@PostMapping("/all-examinations")
	@PreAuthorize("hasRole('ROLE_PATIENT')")
	public  ResponseEntity<List<DermatologistExaminationDTO>> getAllExaminationsForPharmacy(@RequestBody PharmacyExaminationDTO examinationSearch){
		List<DermatologistExaminationDTO> examinations = examinationService.getAllExaminationsForPharmacy(examinationSearch.getId(), examinationSearch.getType());
		return new ResponseEntity<List<DermatologistExaminationDTO>>(examinations, HttpStatus.OK);	
	}
	
	@PostMapping("/examinations")
	@PreAuthorize("hasRole('ROLE_PATIENT')")
	public  ResponseEntity<List<DermatologistExaminationDTO>> getExaminationsForPharmacyAndDate(@RequestBody PharmacyExaminationDTO examinationSearch){
		List<DermatologistExaminationDTO> examinations = examinationService.getExaminationsForPharmacyAndDate(examinationSearch.getId(), examinationSearch.getType(), examinationSearch.getDate());
		return new ResponseEntity<List<DermatologistExaminationDTO>>(examinations, HttpStatus.OK);	
	}
	
	@PostMapping("/search-examinations")
	@PreAuthorize("hasRole('ROLE_PATIENT')")
	public ResponseEntity<List<PharmacyDTO>> getFreePharmaciesForInterval(@RequestBody ExaminationSearchDTO examinationSearchDTO){
		List<Pharmacy> pharmacies=  examinationService.getFreePharmaciesForInterval(examinationSearchDTO.getDate(), examinationSearchDTO.getType());
		List<PharmacyDTO> pharmacyDTOs = new ArrayList<PharmacyDTO>();
		
		pharmacies.forEach(p -> pharmacyDTOs.add(new PharmacyMapper().PharmacyToPharmacyDTO(p)));
		return new ResponseEntity<List<PharmacyDTO>>(pharmacyDTOs, HttpStatus.OK);
	}
}
