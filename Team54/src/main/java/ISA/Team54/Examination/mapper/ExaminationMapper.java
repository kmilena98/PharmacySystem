package ISA.Team54.Examination.mapper;

import ISA.Team54.Examination.dto.DermatologistExaminationDTO;
import ISA.Team54.Examination.model.Examination;
import ISA.Team54.users.model.Dermatologist;

public class ExaminationMapper {
	
	public DermatologistExaminationDTO ExaminationToDermatologistExaminationDTO(Examination examination, Dermatologist dermatologist ) {
		return new DermatologistExaminationDTO(
				examination.getId(), 
				examination.getTerm(), 
				dermatologist.getName() + " " + dermatologist.getSurname(), 
				dermatologist.getRatings(),
				examination.getPrice());
	}
}
