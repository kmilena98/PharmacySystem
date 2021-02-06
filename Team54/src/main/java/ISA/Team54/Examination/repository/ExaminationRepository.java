package ISA.Team54.Examination.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ISA.Team54.Examination.enums.ExaminationStatus;
import ISA.Team54.Examination.enums.ExaminationType;
import ISA.Team54.Examination.model.Examination;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {
	public List<Examination> findAll();
	public List<Examination> findByEmplyeedIdAndStatus(Long id,ExaminationStatus es);
	public List<Examination> findByTypeAndPatientIdAndStatus(ExaminationType type, Long id,ExaminationStatus es);
	public Examination findById(int id);
	public Examination findOneById(Long id);
	public List<Examination> findByEmplyeedId(int id);
	public List<Examination> findByEmplyeedIdAndStatusAndPharmacyId(Long emplyeedId,ExaminationStatus es,Long pharmacyId);
	@Query("SELECT e FROM Examination e where pharmacy_id = ?1 and type = ?2 and status = ?3 ")
	List<Examination> getExaminationsForPharmacy(long id, ExaminationType type, ExaminationStatus status);
}
