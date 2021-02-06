package ISA.Team54.Examination.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import ISA.Team54.Examination.dto.DermatologistExaminationDTO;
import ISA.Team54.Examination.dto.ExaminationDTO;
import ISA.Team54.Examination.model.Examination;
import ISA.Team54.users.model.Dermatologist;
import ISA.Team54.users.model.User;
import ISA.Team54.users.service.interfaces.DermatologistService;
import ISA.Team54.users.service.interfaces.UserService;

public class ExaminationMapper {

	@Autowired
	private DermatologistService dermatologsitService;
	@Autowired
	private UserService userService;
	
	public ExaminationDTO ExaminationToExaminationDTO(Examination examination) {
		return new ExaminationDTO(examination.getId(),examination.getPatient().getName(),examination.getPatient().getSurname(),examination.getTerm().getStart());
	}
	public DermatologistExaminationDTO ExaminationToDermatologistExaminationDTO(Examination examination, Dermatologist dermatologist ) {
		return new DermatologistExaminationDTO(
				examination.getId(), 
				examination.getTerm(), 
				dermatologist.getName() + " " + dermatologist.getSurname(), 
				dermatologist.getRatings(),
				examination.getPrice());
	}
	public ExaminationDTO ExaminationToExaminationDTOHistory(Examination examination,Dermatologist dermatologist) {
		if(dermatologist != null) 
		{
			return new ExaminationDTO(examination.getId(),dermatologist.getName(),dermatologist.getSurname(),examination.getTerm().getStart());
			
		}
		return null;
		}

}
