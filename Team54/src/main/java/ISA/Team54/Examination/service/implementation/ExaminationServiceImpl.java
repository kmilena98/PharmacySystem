package ISA.Team54.Examination.service.implementation;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team54.Examination.dto.ExaminationInformationDTO;
import ISA.Team54.Examination.enums.ExaminationStatus;
import ISA.Team54.Examination.enums.ExaminationType;
import ISA.Team54.Examination.model.Examination;
import ISA.Team54.Examination.repository.ExaminationRepository;
import ISA.Team54.Examination.service.interfaces.ExaminationService;
import ISA.Team54.drugAndRecipe.dto.DrugDTO;
import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.repository.DrugRepository;
import ISA.Team54.users.repository.PatientRepository;

@Service
public class ExaminationServiceImpl implements ExaminationService{
	@Autowired
	private ExaminationRepository examinationRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private DrugRepository drugRepository;
	@Override
	public Examination getCurrentExaminationByDermatologistId(int dermatologistId) {
		//,ExaminationStatus.Unfille nedostaje deo sa statusom 
		List<Examination> dermatologistExaminations = examinationRepository.findByEmplyeedIdAndStatus(dermatologistId, ExaminationStatus.Filled);
		if(dermatologistExaminations.size()<=0) {
			return null;
		}
		Examination soonestExamination = dermatologistExaminations.get(0);
		for(Examination examination : dermatologistExaminations) {
			if(examination.getTerm().getStart().isBefore( soonestExamination.getTerm().getStart())) {
				soonestExamination = examination;	
			}			
		}
		return soonestExamination;
	}
	
	@Override
	public List<Examination> historyOfDermatologistExamination(Long id) {
		return examinationRepository.findByTypeAndPatientIdAndStatus(ExaminationType.DermatologistExamination,id,ExaminationStatus.Filled);
	}
	
	@Override
	public void updateExamination(ExaminationInformationDTO examinationInformationDTO) {
		Examination examination = examinationRepository.findById((examinationInformationDTO.getId()));
		List<Drug> drugsForExamination = new ArrayList<Drug>();
				for(DrugDTO d : examinationInformationDTO.getDrugs()) {
					drugsForExamination.add(drugRepository.findOneById(d.getId()));
				};
		examination.setDiagnose(examinationInformationDTO.getDiagnosis());
		examination.setStatus(ExaminationStatus.Filled);
		examination.setDrugs(drugsForExamination);
		examinationRepository.save(examination);
	}
	
}
