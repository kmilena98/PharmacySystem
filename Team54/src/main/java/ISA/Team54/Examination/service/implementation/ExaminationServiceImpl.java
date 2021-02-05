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
import ISA.Team54.drugAndRecipe.service.interfaces.DrugService;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.repository.PatientRepository;



@Service
public class ExaminationServiceImpl implements ExaminationService{
	@Autowired
	private ExaminationRepository examinationRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private DrugRepository drugRepository;
	@Autowired
	private DrugService drugService;
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
	public List<Examination> historyOfPatientExamination(Long id) {
		return examinationRepository.findByTypeAndPatientIdAndStatus(ExaminationType.DermatologistExamination,id,ExaminationStatus.Filled);
	}
	
	@Override
	public void updateExamination(ExaminationInformationDTO examinationInformationDTO) {
		Examination examination = examinationRepository.findById((examinationInformationDTO.getId()));
		List<Drug> drugsForExamination = new ArrayList<Drug>();
		if(examinationInformationDTO.getDrugs()!=null) {
			for(DrugDTO d : examinationInformationDTO.getDrugs()) {
				drugsForExamination.add(drugRepository.findOneById(d.getId()));
				drugService.reduceDrugQuantityInPharmacy(d.getId(),(int)examination.getPharmacy().getId(),1);
			};
			examination.setDrugs(drugsForExamination);
		}		
		examination.setTherapyDuration(examinationInformationDTO.getTherapyDuration());
		examination.setDiagnose(examinationInformationDTO.getDiagnosis());
		examination.setStatus(ExaminationStatus.Filled);
		
		examinationRepository.save(examination);
	}

	@Override
	public List<Examination> getAllExaminationsForDermatologist(int id) {
		List<Examination> examinations = new ArrayList<Examination>();
		for(Examination e : examinationRepository.findByEmplyeedIdAndStatus(id,ExaminationStatus.Filled)) {
			Patient p = e.getPatient();
			e.setPatient(p);
			examinations.add(e);
		}
		return examinations;
	}
	
}
