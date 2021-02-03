package ISA.Team54.Examination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team54.Examination.dto.ExaminationDTO;
import ISA.Team54.Examination.mapper.ExaminationMapper;
import ISA.Team54.Examination.model.Examination;
import ISA.Team54.Examination.service.interfaces.ExaminationService;
import ISA.Team54.users.service.interfaces.PatientService;

@RestController
@RequestMapping(value = "/examination", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExaminationController {
	@Autowired
	private ExaminationService examinationService;
	private PatientService patientService;
	
	@GetMapping("/soonestExamination/{id}")
	//@PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
	public ExaminationDTO loadSoonestExamination(@PathVariable Long id){
		Examination soonestExamination = examinationService.getCurrentExaminationByDermatologistId(id);
		return new ExaminationMapper().ExaminationToExaminationDTO(soonestExamination);
	}
}
