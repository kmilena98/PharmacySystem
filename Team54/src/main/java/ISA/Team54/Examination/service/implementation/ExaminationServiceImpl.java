package ISA.Team54.Examination.service.implementation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ISA.Team54.Examination.exceptions.ExaminationInvalidTimeLeft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ISA.Team54.Examination.dto.DermatologistExaminationDTO;
import ISA.Team54.Examination.dto.ExaminationInformationDTO;
import ISA.Team54.Examination.enums.ExaminationStatus;
import ISA.Team54.Examination.enums.ExaminationType;
import ISA.Team54.Examination.mapper.ExaminationMapper;
import ISA.Team54.Examination.model.Examination;
import ISA.Team54.Examination.repository.ExaminationRepository;
import ISA.Team54.Examination.service.interfaces.ExaminationService;
import ISA.Team54.drugAndRecipe.dto.DrugDTO;
import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.repository.DrugRepository;
import ISA.Team54.drugAndRecipe.service.interfaces.DrugService;
import ISA.Team54.rating.model.Rating;
import ISA.Team54.users.model.Dermatologist;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.repository.PatientRepository;
import ISA.Team54.users.repository.UserRepository;

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
	@Autowired
	private UserRepository userRepository;
	@Override
	public Examination getCurrentExaminationByDermatologistId(Long dermatologistId) {
		//,ExaminationStatus.Unfille nedostaje deo sa statusom 
		List<Examination> dermatologistExaminations = examinationRepository.findByEmplyeedIdAndStatus(dermatologistId, ExaminationStatus.Filled);
		if(dermatologistExaminations.size()<=0) {
			return null;
		}
		Examination soonestExamination = dermatologistExaminations.get(0);
		for(Examination examination : dermatologistExaminations) {
			if(examination.getTerm().getStart().before( soonestExamination.getTerm().getStart())) {
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
	public List<Examination> getAllExaminationsForDermatologist(Long id) {
		List<Examination> examinations = new ArrayList<Examination>();
		for(Examination e : examinationRepository.findByEmplyeedIdAndStatus(id,ExaminationStatus.Filled)) {
			Patient p = e.getPatient();
			e.setPatient(p);
			examinations.add(e);
		}
		return examinations;
	}
	
	public List<Examination> getDefinedExaminations(int examinationId){
		List<Examination> definedExaminations = new ArrayList<Examination>();
		Examination examination = examinationRepository.findById(examinationId);
		for(Examination ex : examinationRepository.findByEmplyeedIdAndStatusAndPharmacyId(examination.getEmplyeedId(),ExaminationStatus.Unfilled,examination.getPharmacy().getId())) {
			if(examination.getPatient()!=null) {
				definedExaminations.add(ex);
			}
		}
		return definedExaminations;
	}
	@Override
	public List<DermatologistExaminationDTO> getExaminationsForPharmacy(long id) {		
		List<Examination> examinations = examinationRepository.getExaminationsForPharmacy(id, ExaminationType.DermatologistExamination, ExaminationStatus.Unfilled);
		List<Dermatologist> dermatologists = new ArrayList<Dermatologist>();
		List<Rating> ratings = new ArrayList<Rating>();
		examinations.forEach(
				e -> 
				dermatologists.add((Dermatologist) userRepository.findById(e.getEmplyeedId()).orElse(null))
				);
		
		List<DermatologistExaminationDTO> examinationDTOs = new ArrayList<DermatologistExaminationDTO>();
		ExaminationMapper mapper = new ExaminationMapper();
		for(int i = 0; i < examinations.size(); i++) {
			examinationDTOs.add(mapper.ExaminationToDermatologistExaminationDTO(examinations.get(i), dermatologists.get(i)));
		}
		
		return examinationDTOs;
	}


	@Override
	public void scheduleExamination(long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Patient patient = patientRepository.findById(((Patient) authentication.getPrincipal()).getId());
		Examination examination = examinationRepository.findById(id).orElse(null);
		if(examination != null) {
			examination.setStatus(ExaminationStatus.Filled);
			examination.setPatient(patient);

			examinationRepository.save(examination);
		}
	}


	@Override
	public void cancelExamination(long id) throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Patient patient = patientRepository.findById(((Patient) authentication.getPrincipal()).getId());
		Examination examination = examinationRepository.findById(id).orElse(null);
		if(examination != null) {
			if(examination.getTerm().getStart().getTime() - new Date().getTime() > 24 * 60 * 60 * 1000) {
				System.out.println(examination.getTerm().getStart().getTime());
				System.out.println(new Date().getTime());
				examination.setStatus(ExaminationStatus.Unfilled);
				examination.setPatient(null);

				examinationRepository.save(examination);
			}else throw new ExaminationInvalidTimeLeft();
		}else throw new Exception();
	}


	@Override
	public List<DermatologistExaminationDTO> getFutureDermatologistExaminations() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Patient patient = patientRepository.findById(((Patient) authentication.getPrincipal()).getId());
		List<Examination> examinations = examinationRepository.getFutureExaminations(patient.getId(), ExaminationType.DermatologistExamination, ExaminationStatus.Filled);
		List<Dermatologist> dermatologists = new ArrayList<Dermatologist>();
		examinations.forEach(
				e ->
						dermatologists.add((Dermatologist) userRepository.findById(e.getEmplyeedId()).orElse(null))
		);

		List<DermatologistExaminationDTO> examinationDTOs = new ArrayList<DermatologistExaminationDTO>();
		ExaminationMapper mapper = new ExaminationMapper();
		for(int i = 0; i < examinations.size(); i++) {
			examinationDTOs.add(mapper.ExaminationToDermatologistExaminationDTO(examinations.get(i), dermatologists.get(i)));
		}

		return examinationDTOs;
	}
	
}