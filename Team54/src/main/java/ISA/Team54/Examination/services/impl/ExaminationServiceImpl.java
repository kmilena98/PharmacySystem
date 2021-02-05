package ISA.Team54.Examination.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ISA.Team54.Examination.dto.DermatologistExaminationDTO;
import ISA.Team54.Examination.exceptions.ExaminationInvalidTimeLeft;
import ISA.Team54.Examination.mapper.ExaminationMapper;
import ISA.Team54.Examination.model.Examination;
import ISA.Team54.Examination.model.enums.ExaminationStatus;
import ISA.Team54.Examination.model.enums.ExaminationType;
import ISA.Team54.Examination.repository.ExaminationRepository;
import ISA.Team54.Examination.services.ExaminationService;
import ISA.Team54.rating.model.Rating;
import ISA.Team54.users.model.Dermatologist;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.repository.PatientRepository;
import ISA.Team54.users.repository.UserRepository;

@Service
public class ExaminationServiceImpl implements ExaminationService {
	
	@Autowired
	private ExaminationRepository examinationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	

	@Override
	public List<DermatologistExaminationDTO> getExaminationsForPharmacy(long id) {		
		List<Examination> examinations = examinationRepository.getExaminationsForPharmacy(id, ExaminationType.DermatologistExamination, ExaminationStatus.Unfilled);
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
