package ISA.Team54.Examination.mapper;

import ISA.Team54.Examination.dto.ExaminationDTO;
import ISA.Team54.Examination.model.Examination;
import ISA.Team54.users.model.Patient;

public class ExaminationMapper {

	public ExaminationDTO ExaminationToExaminationDTO(Examination examination) {
		return new ExaminationDTO(examination.getPatient().getName(),examination.getPatient().getSurname(),examination.getTerm().getStart(),examination.getTherapyDuration());
	}
}
