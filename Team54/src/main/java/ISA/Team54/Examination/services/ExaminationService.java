package ISA.Team54.Examination.services;

import java.util.List;

import ISA.Team54.Examination.dto.DermatologistExaminationDTO;
import ISA.Team54.Examination.model.Examination;

public interface ExaminationService  {
	List<DermatologistExaminationDTO> getExaminationsForPharmacy(long id);
	void scheduleExamination(long id);
}
