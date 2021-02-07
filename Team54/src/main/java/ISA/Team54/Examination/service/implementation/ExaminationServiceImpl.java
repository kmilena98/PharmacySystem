package ISA.Team54.Examination.service.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ISA.Team54.Examination.dto.DermatologistExaminationDTO;
import ISA.Team54.Examination.dto.ExaminationInformationDTO;
import ISA.Team54.Examination.enums.ExaminationStatus;
import ISA.Team54.Examination.enums.ExaminationType;
import ISA.Team54.Examination.exceptions.ExaminationInvalidTimeLeft;
import ISA.Team54.Examination.mapper.ExaminationMapper;
import ISA.Team54.Examination.model.Examination;
import ISA.Team54.Examination.model.Term;
import ISA.Team54.Examination.repository.ExaminationRepository;
import ISA.Team54.Examination.service.interfaces.ExaminationService;
import ISA.Team54.drugAndRecipe.dto.DrugDTO;
import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.repository.DrugRepository;
import ISA.Team54.drugAndRecipe.service.interfaces.DrugService;
import ISA.Team54.rating.model.Rating;
import ISA.Team54.sharedModel.DateRange;
import ISA.Team54.users.model.Dermatologist;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.Pharmacist;
import ISA.Team54.users.repository.DermatologistRepository;
import ISA.Team54.users.repository.PatientRepository;
import ISA.Team54.users.repository.PharmacistRepository;
import ISA.Team54.users.repository.UserRepository;
import ISA.Team54.vacationAndWorkingTime.model.DermatologistWorkSchedule;
import ISA.Team54.vacationAndWorkingTime.repository.DermatologistWorkScheduleRepository;

@Service
public class ExaminationServiceImpl implements ExaminationService {
	final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs
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
	@Autowired
	private DermatologistRepository dermatologistRepository;
	@Autowired
	private PharmacistRepository pharmacistRepository;
	@Autowired 
	private DermatologistWorkScheduleRepository dermatologistWorkScheduleRepository;

	@Override
	public Examination getCurrentExaminationByDermatologistId(Long dermatologistId) {
		// ,ExaminationStatus.Unfille nedostaje deo sa statusom
		List<Examination> dermatologistExaminations = examinationRepository.findByEmplyeedIdAndStatus(dermatologistId,
				ExaminationStatus.Filled);
		if (dermatologistExaminations.size() <= 0) {
			return null;
		}
		Examination soonestExamination = dermatologistExaminations.get(0);
		for (Examination examination : dermatologistExaminations) {
			if (examination.getTerm().getStart().before(soonestExamination.getTerm().getStart())) {
				soonestExamination = examination;
			}
		}
		return soonestExamination;
	}

	@Override
	public List<Examination> historyOfPatientExamination(Long id) {
		ExaminationType examinaitonType = ExaminationType.DermatologistExamination;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Pharmacist pharmacist = pharmacistRepository.findOneById(((Dermatologist) authentication.getPrincipal()).getId());
		if(pharmacist != null) {
			examinaitonType = ExaminationType.PharmacistExamination;
		}
		return examinationRepository.getHistoryExaminationsForPatient( id,examinaitonType,ExaminationStatus.Filled);
	}

	@Override
	public void updateExamination(ExaminationInformationDTO examinationInformationDTO) {
		Examination examination = examinationRepository.findOneById((examinationInformationDTO.getId()));
		List<Drug> drugsForExamination = new ArrayList<Drug>();
		if (examinationInformationDTO.getDrugs() != null) {
			for (DrugDTO d : examinationInformationDTO.getDrugs()) {
				drugsForExamination.add(drugRepository.findOneById(d.getId()));
				drugService.reduceDrugQuantityInPharmacy(d.getId(), (int) examination.getPharmacy().getId(), 1);
			}
			;
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
		for (Examination e : examinationRepository.findByEmplyeedIdAndStatus(id, ExaminationStatus.Filled)) {
			Patient p = e.getPatient();
			e.setPatient(p);
			examinations.add(e);
		}
		return examinations;
	}

	public List<Examination> getDefinedExaminations(long examinationId) {
		List<Examination> definedExaminations = new ArrayList<Examination>();
		Examination examination = examinationRepository.findOneById(examinationId);
		for (Examination ex : examinationRepository.findByEmplyeedIdAndStatusAndPharmacyId(examination.getEmplyeedId(),
				ExaminationStatus.Unfilled, examination.getPharmacy().getId())) {
			if (examination.getPatient() != null) {
				definedExaminations.add(ex);
			}
		}
		return definedExaminations;
	}

	@Override
	public List<DermatologistExaminationDTO> getExaminationsForPharmacy(long id) {
		List<Examination> examinations = examinationRepository.getExaminationsForPharmacy(id,
		ExaminationType.DermatologistExamination, ExaminationStatus.Unfilled);
		List<Dermatologist> dermatologists = new ArrayList<Dermatologist>();
		List<Rating> ratings = new ArrayList<Rating>();
		examinations.forEach(
				e -> dermatologists.add((Dermatologist) userRepository.findById(e.getEmplyeedId()).orElse(null)));

		List<DermatologistExaminationDTO> examinationDTOs = new ArrayList<DermatologistExaminationDTO>();
		ExaminationMapper mapper = new ExaminationMapper();
		for (int i = 0; i < examinations.size(); i++) {
			examinationDTOs
					.add(mapper.ExaminationToDermatologistExaminationDTO(examinations.get(i), dermatologists.get(i)));
		}

		return examinationDTOs;
	}

	@Override
	public void scheduleExamination(long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Patient patient = patientRepository.findById(((Patient) authentication.getPrincipal()).getId());
		Examination examination = examinationRepository.findById(id).orElse(null);
		if (examination != null) {
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

	
	  private boolean isDermatologistOnWorkInTheParmacy(Long dermatologistId,Long pharmacyId,DateRange examinationTime) {
		  Dermatologist dermatologist = dermatologistRepository.findOneById(dermatologistId);
		  List<DermatologistWorkSchedule> workingSchedules = dermatologistWorkScheduleRepository.findByDermatologistIdAndPharmacyId(dermatologistId,pharmacyId);
		  for(DermatologistWorkSchedule workingSchedule : workingSchedules) {
			  if(workingSchedule.getPharmacy().getId()==pharmacyId && examinationTime.isInRange(new DateRange(workingSchedule.getTimePeriod().getStartDate(),workingSchedule.getTimePeriod().getEndDate()))) {
				
				  return true;
			  }
		  }
		  return false;
	  }
	  
	  
	  private boolean isDermatologistAvailable(Long dermatologistId,Long pharmacyId,Date start,Date end) {
		  if(!isDermatologistOnWorkInTheParmacy(dermatologistId,pharmacyId,new DateRange(start,end))) {
			  return false;
		  }
		  for(Examination dermatologistExamination : examinationRepository.findByEmplyeedIdAndPharmacyId(dermatologistId,pharmacyId)) {
			  Term term = dermatologistExamination.getTerm();
			  if((new DateRange(start,end)).isTheDateBetweenDates(term.getStart())) {
				  return false;
			  }
		  }
	  return true;
	  }
	  private boolean isPatientAvailable(Long patientId,Date start,Date end) {
		 
		  for(Examination examination : examinationRepository.findByPatientId(patientId)) {
			  Term term = examination.getTerm();
			  if((new DateRange(start,end)).isTheDateBetweenDates(term.getStart())) {
				  return false;
			  }
		  }
		  return true;
	  }
	  
	 
	public boolean canExaminationBeScheduled(Examination examination, Date start,Date end) {
		if(!isDermatologistAvailable(examination.getEmplyeedId(),examination.getPharmacy().getId(),start,end))
			return false;
		if(!isPatientAvailable(examination.getPatient().getId(),start,end)){
			return false;
		}
		return true;
	}
	public boolean scheduleExamination(Long examinationId,Date start) {
		long curTimeInMs = start.getTime();
		Date end = new Date(curTimeInMs + (30 * ONE_MINUTE_IN_MILLIS));
		Examination examination = examinationRepository.findOneById(examinationId);
		if(!canExaminationBeScheduled( examination, start,end)) {
			return false;
		}
		Examination newExamination = new Examination();
		newExamination.setPrice(examination.getPrice());
		newExamination.setType(examination.getType());
		newExamination.setStatus(ExaminationStatus.Filled);
		newExamination.setEmplyeedId(examination.getEmplyeedId());
		newExamination.setPatient(examination.getPatient());
		newExamination.setTerm(new Term(start,30));
		newExamination.setPharmacy(examination.getPharmacy());
		examinationRepository.save(newExamination);
		return true;
	}
	
	public boolean saveExamination(Long currentExaminationId,Long newExaminationId) {
		Examination currentExamination = examinationRepository.findOneById(currentExaminationId);
		Examination newExamination = examinationRepository.findOneById(newExaminationId);
		newExamination.setStatus(ExaminationStatus.Filled);
		newExamination.setPatient(currentExamination.getPatient());
		examinationRepository.save(newExamination);
		return true;
	}

}
