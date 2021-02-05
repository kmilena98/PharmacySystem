package ISA.Team54.Examination.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
