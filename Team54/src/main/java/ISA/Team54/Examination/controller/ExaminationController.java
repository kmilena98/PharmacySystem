package ISA.Team54.Examination.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team54.Examination.dto.DermatologistExaminationDTO;
import ISA.Team54.Examination.exceptions.ExaminationInvalidTimeLeft;
import ISA.Team54.Examination.model.Examination;
import ISA.Team54.Examination.services.ExaminationService;


@RestController
@RequestMapping(value = "/examination", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExaminationController {
	
	@Autowired
	private ExaminationService examinationService;
	
	@GetMapping("/schedule/{id}")
	@PreAuthorize("hasRole('ROLE_PATIENT')")
	public void scheduleExamination(@PathVariable long id) {
		examinationService.scheduleExamination(id);
	}
	
	@GetMapping("/cancel/{id}")
	@PreAuthorize("hasRole('ROLE_PATIENT')")
	public ResponseEntity<String> cancelExamination(@PathVariable long id) {
		try {
			examinationService.cancelExamination(id);
			return new ResponseEntity<>(HttpStatus.OK);			
		}catch(ExaminationInvalidTimeLeft e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@GetMapping("/future")
	@PreAuthorize("hasRole('ROLE_PATIENT')")
	public ResponseEntity<List<DermatologistExaminationDTO>> getFutureExamination() {
		try {
			List<DermatologistExaminationDTO> examinations = examinationService.getFutureDermatologistExaminations();
			return new ResponseEntity<List<DermatologistExaminationDTO>>(examinations, HttpStatus.OK);			
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
