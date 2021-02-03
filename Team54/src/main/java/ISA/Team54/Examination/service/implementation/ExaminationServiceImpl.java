package ISA.Team54.Examination.service.implementation;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team54.Examination.enums.ExaminationStatus;
import ISA.Team54.Examination.model.Examination;
import ISA.Team54.Examination.repository.ExaminationRepository;
import ISA.Team54.Examination.service.interfaces.ExaminationService;
import ISA.Team54.users.repository.PatientRepository;

@Service
public class ExaminationServiceImpl implements ExaminationService{
	@Autowired
	private ExaminationRepository examinationRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Override
	public Examination getCurrentExaminationByDermatologistId(Long dermatologistId) {
		List<Examination> dermatologistExaminations = examinationRepository.findEmplyeedIdAndExaminationStatus(dermatologistId,ExaminationStatus.Unfilled);
		if(dermatologistExaminations.size()<=0) {
			return null;
		}
		Examination soonestExamination = dermatologistExaminations.get(0);
		for(Examination examination : dermatologistExaminations) {
			if(examination.getTerm().getStart().isBefore((ChronoLocalDateTime<?>) soonestExamination)) {
				soonestExamination = examination;	
			}			
		}
		return soonestExamination;
	}
	
}
