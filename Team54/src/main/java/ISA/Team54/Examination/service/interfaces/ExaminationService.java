package ISA.Team54.Examination.service.interfaces;

import java.util.List;

import ISA.Team54.Examination.dto.ExaminationInformationDTO;
import ISA.Team54.Examination.enums.ExaminationStatus;
import ISA.Team54.Examination.enums.ExaminationType;
import ISA.Team54.Examination.model.Examination;

public interface ExaminationService {
	public Examination getCurrentExaminationByDermatologistId(int dermatologistId);
	public List<Examination> historyOfPatientExamination(Long id);
	public void updateExamination(ExaminationInformationDTO examinationInformationDTO);
	public List<Examination> getAllExaminationsForDermatologist(int id);
	public List<Examination> getDefinedExaminations(int examinationId);
}
