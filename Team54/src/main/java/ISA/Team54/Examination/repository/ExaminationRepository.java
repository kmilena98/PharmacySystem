package ISA.Team54.Examination.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ISA.Team54.Examination.model.Examination;
import ISA.Team54.Examination.model.enums.ExaminationStatus;
import ISA.Team54.Examination.model.enums.ExaminationType;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {
	
	@Query("SELECT e FROM Examination e where pharmacy_id = ?1 and type = ?2 and status = ?3 ")
	List<Examination> getExaminationsForPharmacy(long id, ExaminationType type, ExaminationStatus status);
	
	@Query("SELECT e FROM Examination e where patient_id = ?1 and type = ?2 and status = ?3 and start > CURRENT_TIMESTAMP") 
	List<Examination> getFutureExaminations(long id, ExaminationType type, ExaminationStatus status);
}
