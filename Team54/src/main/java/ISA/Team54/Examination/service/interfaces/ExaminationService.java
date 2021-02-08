package ISA.Team54.Examination.service.interfaces;
import java.util.Date;
import java.util.List;

import ISA.Team54.Examination.dto.DermatologistExaminationDTO;
import ISA.Team54.Examination.dto.ExaminationInformationDTO;
import ISA.Team54.Examination.enums.ExaminationType;
import ISA.Team54.Examination.model.Examination;
import ISA.Team54.users.model.Pharmacy;

public interface ExaminationService {
	public Examination getCurrentExaminationByDermatologistId();
	public List<Examination> historyOfPatientExamination(Long id);
	public void updateExamination(ExaminationInformationDTO examinationInformationDTO);
	public List<Examination> getAllExaminationsForDermatologist(Long id);
	public List<Examination> getDefinedExaminations(long examinationId);
	List<DermatologistExaminationDTO> getAllExaminationsForPharmacy(long id, ExaminationType type);
	List<DermatologistExaminationDTO> getExaminationsForPharmacyAndDate(long id, ExaminationType type, Date date);
	void scheduleExamination(long id);
	boolean canExaminationBeScheduled(Examination examination, Date start,Date end);
	boolean scheduleExamination(Long examinationId,Date start);
	void cancelExamination(long id) throws Exception;
	boolean saveExamination(Long currentExaminationId,Long newExaminationId);
	List<DermatologistExaminationDTO> getFutureExaminations(ExaminationType type);
	List<Pharmacy> getFreePharmaciesForInterval(Date term, ExaminationType type);
	int isPatientAppropriate(Long patientId);
}
